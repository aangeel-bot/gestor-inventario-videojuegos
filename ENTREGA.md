# Guia de entrega - Proyecto ESPE

Este documento contiene el texto listo para tu PDF de entrega y las instrucciones de capturas de pantalla.

---

## 15. Enlace al repositorio de GitHub

Sustituye la URL cuando hayas subido el proyecto:

```
https://github.com/TU_USUARIO/gestor-inventario-videojuegos
```

**Pasos para subir a GitHub (hazlo tu):**

1. Entra en https://github.com/new
2. Crea un repositorio llamado `gestor-inventario-videojuegos` (publico o privado con acceso al profesor)
3. En PowerShell, dentro de la carpeta del proyecto:

```powershell
cd "c:\Users\angel\Desktop\Nueva carpeta"
git remote add origin https://github.com/TU_USUARIO/gestor-inventario-videojuegos.git
git push -u origin main
git push origin feature/sistema-descuentos
git push origin hotfix/correccion-precios
git push origin v1.0.0
```

4. Activa GitHub Pages: **Settings > Pages > Branch: main, Folder: /docs**

Si `gh auth login` falla, usa la web de GitHub para crear el repo y el push con HTTPS.

---

## 16. Captura del conflicto + explicacion

### Cuando hacer la captura

La captura del conflicto debia hacerse **en el momento del merge**, antes de resolver el archivo. Si no la hiciste, puedes usar una de estas alternativas:

**Opcion A (recomendada):** Abre `src/modelo/Item.java` en el historial de Git de Cursor/VS Code y localiza el commit de merge `48bdc07` — en la vista de diff anterior veras los marcadores `<<<<<<<`, `=======`, `>>>>>>>`.

**Opcion B:** Repite el conflicto en una rama de prueba:

```powershell
git checkout -b demo-conflicto
git merge feature/sistema-descuentos
# CAPTURA AQUI la terminal o el archivo con conflict markers
git merge --abort
git checkout main
git branch -D demo-conflicto
```

### Texto para pegar en el PDF (parrafo explicativo)

> Al fusionar la rama `feature/sistema-descuentos` en `main`, Git detecto un conflicto en el metodo `calcularPrecioFinal()` de la clase `Item`. La rama `hotfix/correccion-precios` habia anadido un recargo fijo de 5 euros al precio base, mientras que la rama `feature/sistema-descuentos` aplicaba un descuento porcentual sobre el precio base. Resolvi el conflicto manualmente combinando ambas logicas: primero se suma el recargo de gestion y despues se aplica el descuento porcentual, con la formula `(precioBase + 5.0) * (1 - porcentajeDescuento / 100.0)`. De este modo el codigo compila, mantiene las dos funcionalidades y el inventario sigue calculando precios de forma coherente.

---

## 17. Grafo de commits

Ejecuta en la terminal y haz captura:

```powershell
cd "c:\Users\angel\Desktop\Nueva carpeta"
git log --graph --oneline --all
```

Debe verse `main`, `feature/sistema-descuentos`, `hotfix/correccion-precios` y el commit de merge.

**Alternativa:** En GitHub, pestana **Insights > Network** (o la vista de ramas del repositorio).

---

## Captura extra recomendada (rubrica GitHub Pages)

Tras activar Pages, abre en el navegador:

```
https://TU_USUARIO.github.io/gestor-inventario-videojuegos/
```

Captura la pagina principal del Javadoc generado.

---

## Checklist final

- [ ] Repositorio en GitHub con todo el codigo
- [ ] Minimo 15 commits con prefijos `[add]`, `[fix]`, etc. (actualmente: 19 commits)
- [ ] Ramas `feature/sistema-descuentos` y `hotfix/correccion-precios` subidas
- [ ] Tag `v1.0.0` subido
- [ ] GitHub Pages activo con carpeta `/docs`
- [ ] PDF con enlace, captura de conflicto, grafo de commits

---

## Resumen de capturas para el PDF

| # | Que capturar | Obligatorio |
|---|--------------|-------------|
| 1 | Conflicto Git (terminal o IDE con `<<<<<<<`) | Si |
| 2 | `git log --graph --oneline --all` | Si |
| 3 | Javadoc en GitHub Pages | Muy recomendable |
| 4 | URL del repositorio en GitHub | Si (como enlace) |
