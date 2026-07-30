# Hotel La Cricka de Martha

Sistema de gestión hotelera de escritorio (Java/Swing) desarrollado como
práctica guiada del curso IF3001: reservas por habitación con fechas,
disponibilidad, cargos de alimentación asociados y reportes.

> Proyecto de equipo (4 personas). Ver historial de commits para la
> contribución individual de cada integrante.

## Características

- Gestión de habitaciones (`Room`) y su disponibilidad.
- Reservas (`Reservation`) con validación de fechas y cálculo de costo por
  noche, incluyendo detección de solapamiento con reservas existentes.
- Cargos de alimentación asociados a una reserva, organizados por
  categoría (`Food`, `FoodCategory`).
- Reportes de ocupación y consumo (`ReportController`).
- Temas de interfaz claro/oscuro (`Themes`) sobre FlatLaf.

## Tecnologías

- **Java 8** (Swing/AWT), proyecto Eclipse sin gestor de dependencias.
- **FlatLaf** + **SwingX** para la interfaz.
- **JCalendar** para selección de fechas.
- Persistencia en memoria (sin base de datos): los datos viven mientras
  la aplicación está abierta.

## Arquitectura

MVC bajo `com.practicaguiadauno`:

```
mvc/
  model/        → Room, Reservation, Food, FoodCategory y sus listas
  controllers/   → ReservationController, FoodController, ReportController
  view/          → ViewMajor + paneles por caso de uso (crear/editar/ver)
utils/           → carga de imágenes, temas, fuentes, mensajes
init/            → Main
```

El controlador de reservas empezó como una única clase que mezclaba
reservas, alimentación y reportes. Se refactorizó dividiéndolo en
`ReservationController`, `FoodController` y `ReportController` por
responsabilidad, y se migró el modelo de nombres en español a inglés
(`Reservacion → Reservation`, `Habitacion → Room`, etc.) para dejar una
base más mantenible.

## Instalación y ejecución

Requiere JDK 8 o superior.

1. Clona el repositorio.
2. Importa la carpeta `PracticaGuiada` como proyecto existente en Eclipse
   (`File → Import → Existing Projects into Workspace`).
3. Ejecuta la clase `com.practicaguiadauno.init.Main`.

## Estado del proyecto

Proyecto académico cerrado. No usa base de datos ni persistencia en
disco: es una demostración de modelado de dominio y arquitectura MVC en
Java puro, no una aplicación en producción.

## Créditos

Desarrollado para el curso IF3001.
