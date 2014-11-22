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
    public class PartidoController : Controller
    {
        private ModelContainer db = new ModelContainer();

        //
        // GET: /Partido/

        public ActionResult Index()
        {
            var partidoset = db.PartidoSet.Include(p => p.EstadoPartido);
            return View(partidoset.ToList());
        }

        //
        // GET: /Partido/Details/5

        public ActionResult Details(int id = 0)
        {
            Partido partido = db.PartidoSet.Find(id);
            if (partido == null)
            {
                return HttpNotFound();
            }
            return View(partido);
        }

        //
        // GET: /Partido/Create

        public ActionResult Create()
        {
            ViewBag.EstadoPartidoId = new SelectList(db.EstadoPartidoSet, "Id", "Descripcion");
            return View();
        }

        //
        // POST: /Partido/Create

        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult Create(Partido partido)
        {
            if (ModelState.IsValid)
            {
                db.PartidoSet.Add(partido);
                db.SaveChanges();
                return RedirectToAction("Index");
            }

            ViewBag.EstadoPartidoId = new SelectList(db.EstadoPartidoSet, "Id", "Descripcion", partido.EstadoPartidoId);
            return View(partido);
        }

        //
        // GET: /Partido/Edit/5

        public ActionResult Edit(int id = 0)
        {
            Partido partido = db.PartidoSet.Find(id);
            if (partido == null)
            {
                return HttpNotFound();
            }
            ViewBag.EstadoPartidoId = new SelectList(db.EstadoPartidoSet, "Id", "Descripcion", partido.EstadoPartidoId);
            return View(partido);
        }

        //
        // POST: /Partido/Edit/5

        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult Edit(Partido partido)
        {
            if (ModelState.IsValid)
            {
                db.Entry(partido).State = System.Data.Entity.EntityState.Modified;
                db.SaveChanges();
                return RedirectToAction("Index");
            }
            ViewBag.EstadoPartidoId = new SelectList(db.EstadoPartidoSet, "Id", "Descripcion", partido.EstadoPartidoId);
            return View(partido);
        }

        //
        // GET: /Partido/Delete/5

        public ActionResult Delete(int id = 0)
        {
            Partido partido = db.PartidoSet.Find(id);
            if (partido == null)
            {
                return HttpNotFound();
            }
            return View(partido);
        }

        //
        // POST: /Partido/Delete/5

        [HttpPost, ActionName("Delete")]
        [ValidateAntiForgeryToken]
        public ActionResult DeleteConfirmed(int id)
        {
            Partido partido = db.PartidoSet.Find(id);
            db.PartidoSet.Remove(partido);
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