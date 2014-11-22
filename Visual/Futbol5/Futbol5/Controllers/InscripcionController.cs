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
    public class InscripcionController : Controller
    {
        private ModelContainer db = new ModelContainer();

        //
        // GET: /Inscripcion/

        public ActionResult Index()
        {
            var inscripcionset = db.InscripcionSet.Include(i => i.Partido).Include(i => i.Jugador).Include(i => i.TipoInscripcion);
            return View(inscripcionset.ToList());
        }

        //
        // GET: /Inscripcion/Details/5

        public ActionResult Details(int id = 0)
        {
            Inscripcion inscripcion = db.InscripcionSet.Find(id);
            if (inscripcion == null)
            {
                return HttpNotFound();
            }
            return View(inscripcion);
        }

        //
        // GET: /Inscripcion/Create

        public ActionResult Create()
        {
            ViewBag.PartidoId = new SelectList(db.PartidoSet, "Id", "Administrador");
            ViewBag.JugadorId = new SelectList(db.JugadorSet, "Id", "Nombre");
            ViewBag.TipoInscripcionId = new SelectList(db.TipoInscripcionSet, "Id", "Descripcion");
            return View();
        }

        //
        // POST: /Inscripcion/Create

        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult Create(Inscripcion inscripcion)
        {
            if (ModelState.IsValid)
            {
                db.InscripcionSet.Add(inscripcion);
                db.SaveChanges();
                return RedirectToAction("Index");
            }

            ViewBag.PartidoId = new SelectList(db.PartidoSet, "Id", "Administrador", inscripcion.PartidoId);
            ViewBag.JugadorId = new SelectList(db.JugadorSet, "Id", "Nombre", inscripcion.JugadorId);
            ViewBag.TipoInscripcionId = new SelectList(db.TipoInscripcionSet, "Id", "Descripcion", inscripcion.TipoInscripcionId);
            return View(inscripcion);
        }

        //
        // GET: /Inscripcion/Edit/5

        public ActionResult Edit(int id = 0)
        {
            Inscripcion inscripcion = db.InscripcionSet.Find(id);
            if (inscripcion == null)
            {
                return HttpNotFound();
            }
            ViewBag.PartidoId = new SelectList(db.PartidoSet, "Id", "Administrador", inscripcion.PartidoId);
            ViewBag.JugadorId = new SelectList(db.JugadorSet, "Id", "Nombre", inscripcion.JugadorId);
            ViewBag.TipoInscripcionId = new SelectList(db.TipoInscripcionSet, "Id", "Descripcion", inscripcion.TipoInscripcionId);
            return View(inscripcion);
        }

        //
        // POST: /Inscripcion/Edit/5

        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult Edit(Inscripcion inscripcion)
        {
            if (ModelState.IsValid)
            {
                db.Entry(inscripcion).State = System.Data.Entity.EntityState.Modified;
                db.SaveChanges();
                return RedirectToAction("Index");
            }
            ViewBag.PartidoId = new SelectList(db.PartidoSet, "Id", "Administrador", inscripcion.PartidoId);
            ViewBag.JugadorId = new SelectList(db.JugadorSet, "Id", "Nombre", inscripcion.JugadorId);
            ViewBag.TipoInscripcionId = new SelectList(db.TipoInscripcionSet, "Id", "Descripcion", inscripcion.TipoInscripcionId);
            return View(inscripcion);
        }

        //
        // GET: /Inscripcion/Delete/5

        public ActionResult Delete(int id = 0)
        {
            Inscripcion inscripcion = db.InscripcionSet.Find(id);
            if (inscripcion == null)
            {
                return HttpNotFound();
            }
            return View(inscripcion);
        }

        //
        // POST: /Inscripcion/Delete/5

        [HttpPost, ActionName("Delete")]
        [ValidateAntiForgeryToken]
        public ActionResult DeleteConfirmed(int id)
        {
            Inscripcion inscripcion = db.InscripcionSet.Find(id);
            db.InscripcionSet.Remove(inscripcion);
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