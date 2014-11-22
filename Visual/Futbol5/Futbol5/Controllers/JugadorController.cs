using System;
using System.Collections.Generic;
using System.Data;
using System.Data.Entity;
using System.Linq;
using System.Web;
using System.Web.Mvc;
using Futbol5.Models;

namespace Futbol5.Controllers
{
    public class JugadorController : Controller
    {
        private ModelContainer db = new ModelContainer();

        //
        // GET: /Jugador/

        public ActionResult Index()
        {   
            return View(db.JugadorSet.ToList());
         }

        //
        // POST: /Jugador/
        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult Index(FiltroJugador filtro)
        {
            ViewBag.FiltroJugador = filtro;

            var jugadores = db.JugadorSet.ToList<Jugador>().Where(j => j.CumpleCon(filtro));

            return View(jugadores.ToList());
        }

        //public ActionResult Index(string comienza, string contiene, string nacimiento, string handicap_desde, string handicap_hasta, string promedio_desde, string promedio_hasta)
        //{

        //    FiltroJugador filtro = new FiltroJugador { comienza = comienza, contiene = contiene };

        //    if (nacimiento != null && nacimiento != "")
        //        filtro.nacimiento = DateTime.Parse(nacimiento);
        //    if (handicap_desde != null && handicap_desde != "")
        //        filtro.handicap_desde = int.Parse(handicap_desde);
        //    if (handicap_hasta != null && handicap_hasta != "")
        //        filtro.handicap_hasta = int.Parse(handicap_hasta);
        //    if (promedio_desde != null && promedio_desde != "")
        //        filtro.promedio_desde = int.Parse(promedio_desde);
        //    if (promedio_hasta != null && promedio_hasta != "")
        //        filtro.promedio_hasta = int.Parse(promedio_hasta);

        //    ViewBag.FiltroJugador = filtro;

        //    var jugadores = db.JugadorSet.ToList<Jugador>().Where(j => j.CumpleCon(filtro));

        //    return View(jugadores.ToList());
        //}
        //public ActionResult Index(FiltroJugador filtro)
        //{
        //    ViewBag.FiltroJugador = filtro;

        //    var jugadores = db.JugadorSet.ToList<Jugador>().Where(j => j.CumpleCon(filtro));

        //    return View(jugadores.ToList());
        //}


        //
        // GET: /Jugador/Details/5

        public ActionResult Details(int id = 0)
        {
            Jugador jugador = db.JugadorSet.Find(id);
            if (jugador == null)
            {
                return HttpNotFound();
            }
            return View(new JugadorViewModel(jugador));
        }

        //
        // GET: /Jugador/Create

        public ActionResult Create()
        {
            return View();
        }

        //
        // POST: /Jugador/Create

        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult Create(Jugador jugador)
        {
            if (ModelState.IsValid)
            {
                db.JugadorSet.Add(jugador);
                db.SaveChanges();
                return RedirectToAction("Index");
            }

            return View(jugador);
        }

        //
        // GET: /Jugador/Edit/5

        public ActionResult Edit(int id = 0)
        {
            Jugador jugador = db.JugadorSet.Find(id);
            if (jugador == null)
            {
                return HttpNotFound();
            }
            return View(jugador);
        }

        //
        // POST: /Jugador/Edit/5

        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult Edit(Jugador jugador)
        {
            if (ModelState.IsValid)
            {
                db.Entry(jugador).State = System.Data.Entity.EntityState.Modified;
                db.SaveChanges();
                return RedirectToAction("Index");
            }
            return View(jugador);
        }

        //
        // GET: /Jugador/Delete/5

        public ActionResult Delete(int id = 0)
        {
            Jugador jugador = db.JugadorSet.Find(id);
            if (jugador == null)
            {
                return HttpNotFound();
            }
            return View(jugador);
        }

        //
        // POST: /Jugador/Delete/5

        [HttpPost, ActionName("Delete")]
        [ValidateAntiForgeryToken]
        public ActionResult DeleteConfirmed(int id)
        {
            Jugador jugador = db.JugadorSet.Find(id);
            db.JugadorSet.Remove(jugador);
            db.SaveChanges();
            return RedirectToAction("Index");
        }

        protected override void Dispose(bool disposing)
        {
            db.Dispose();
            base.Dispose(disposing);
        }
    }
}