using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace Futbol5.Models
{
    public class FiltroJugador
    {
        public string comienza { get; set; }
        public string contiene { get; set; }
        public string nacimiento { get; set; }
        public string handicap_desde { get; set; }
        public string handicap_hasta { get; set; }
        public string promedio_desde { get; set; }
        public string promedio_hasta { get; set; }
        public string tuvo_infracciones { get; set; }

        public FiltroJugador()
        {

        }

        internal bool cumple(Jugador j)
        {
            FiltroConv f = new FiltroConv();
            if (nacimiento != null && nacimiento != "")
                f.nacimiento = DateTime.Parse(nacimiento);
            if (handicap_desde != null && handicap_desde != "")
                f.handicap_desde = int.Parse(handicap_desde);
            if (handicap_hasta != null && handicap_hasta != "")
                f.handicap_hasta = int.Parse(handicap_hasta);
            if (promedio_desde != null && promedio_desde != "")
                f.promedio_desde = int.Parse(promedio_desde);
            if (promedio_hasta != null && promedio_hasta != "")
                f.promedio_hasta = int.Parse(promedio_hasta);

            bool flag = false;
            if ((comienza!=null && j.Nombre.StartsWith(comienza))
                || (f.contiene != null && j.Nombre.Contains(contiene))
                || (f.nacimiento.HasValue && j.Fecha_Nac.CompareTo(f.nacimiento.Value)<0)
                || (f.handicap_desde.HasValue && j.Handicap.HasValue && j.Handicap > f.handicap_desde.Value)
                || (f.handicap_hasta.HasValue && j.Handicap.HasValue && j.Handicap > f.handicap_hasta.Value))
            {
               flag = true;
               if (f.tuvo_infracciones.HasValue && (f.tuvo_infracciones.Value != (j.Infraccion.Count > 0)))
                   flag = false;
            }

            return flag;
        }
    }

    public class FiltroConv
    {
        public string comienza { get; set; }
        public string contiene { get; set; }
        public DateTime? nacimiento { get; set; }
        public int? handicap_desde { get; set; }
        public int? handicap_hasta { get; set; }
        public int? promedio_desde { get; set; }
        public int? promedio_hasta { get; set; }
        public bool? tuvo_infracciones { get; set; }

    }
}
