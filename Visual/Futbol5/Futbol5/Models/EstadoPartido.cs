//------------------------------------------------------------------------------
// <auto-generated>
//    This code was generated from a template.
//
//    Manual changes to this file may cause unexpected behavior in your application.
//    Manual changes to this file will be overwritten if the code is regenerated.
// </auto-generated>
//------------------------------------------------------------------------------

namespace Futbol5.Models
{
    using System;
    using System.Collections.Generic;
    
    public partial class EstadoPartido
    {
        public EstadoPartido()
        {
            this.Partido = new HashSet<Partido>();
        }
    
        public int Id { get; set; }
        public string Descripcion { get; set; }
    
        public virtual ICollection<Partido> Partido { get; set; }
    }
}
