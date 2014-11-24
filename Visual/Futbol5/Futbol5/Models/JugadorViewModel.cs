using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace Futbol5.Models
{
    public class JugadorViewModel
    {
        public Jugador jugador;
        public FiltroJugador filtro = new FiltroJugador();

        public JugadorViewModel(Jugador jugador)
        {
            this.jugador = jugador;
        }

        public double PromedioUltPartido
        {
            get
            {
                if (jugador.CalificacionesRecibidas.Count > 0)
                    return jugador.CalificacionesRecibidas.Where(cal => cal.PartidoId == (jugador.CalificacionesRecibidas.OrderByDescending(c => c.Partido.Id).First().PartidoId)).Average(c2 => c2.Nota);
                else return 0;
            }
        }
        public double PromedioCalificaciones
        {
            get
            {
                if (jugador.CalificacionesRecibidas.Count > 0)
                    return jugador.CalificacionesRecibidas.Average(c => c.Nota);
                else return 0;
            }
        }

    }
}