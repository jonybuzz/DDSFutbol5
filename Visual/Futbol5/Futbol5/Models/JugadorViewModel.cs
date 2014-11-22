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
                return jugador.CalificacionesRecibidas.Where(cal => cal.PartidoId == (jugador.CalificacionesRecibidas.OrderByDescending(c => c.Partido.Id).First().PartidoId)).Average(c2 => c2.Nota);
            }
        }
        public double PromedioCalificaciones
        {
            get
            {
                return jugador.CalificacionesRecibidas.Average(c => c.Nota);
            }
        }

        public string HandicapColor
        {
            get
            {
                if (this.jugador.Handicap != null && this.jugador.Handicap > 8)
                    return "blue";
                else return "black";
            }
        }

        public bool CumpleFiltro
        {
            get
            {
                return filtro.cumple(this.jugador);
            }
        }
    }
}