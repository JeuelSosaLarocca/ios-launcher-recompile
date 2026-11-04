# Cómo usar el launcher

Guía rápida de esta copia. Las capturas de ejemplo están en el [README](../README.md). El original traía un video de ayuda
en YouTube; esta guía lo reemplaza.

## 1. Empezar

1. Instalá la app (pasos en el [README](../README.md#instalar-y-usar)).
2. Abrila una vez desde el ícono **iOS Launcher**. Es la pantalla de ajustes del launcher.
3. Elegila como launcher por defecto: en esa pantalla, la fila **Make Default Launcher**, o en Android
   *Ajustes → Apps → Apps predeterminadas → Aplicación de inicio*.
4. Apretá el botón de inicio: ya ves la pantalla de inicio al estilo iOS.

Los permisos se piden cuando una función los necesita; podés negarlos y seguir usando el resto (ver [PRIVACY.md](PRIVACY.md)).

## 2. La pantalla de inicio

- **Páginas e íconos:** deslizá a izquierda y derecha para cambiar de página. Mantené presionado un ícono para moverlo,
  cambiarlo de página o quitarlo de la pantalla de inicio (la app sigue instalada y aparece en la biblioteca).
- **Carpetas:** arrastrá un ícono sobre otro para crear una carpeta; tocala para abrirla.
- **Dock:** los cuatro íconos de abajo se ven en todas las páginas.
- **Buscar:** el botón *Buscar* sobre el dock abre el buscador de apps y la búsqueda web.

## 3. Vista Hoy (widgets)

Desde la primera página, deslizá hacia la derecha. Ahí viven los widgets: clima, batería, calendario, foto, contactos
favoritos y otros. El botón **Editar**, al final de la página, sirve para agregar o quitar widgets.

## 4. Biblioteca de aplicaciones

Desde la última página, deslizá hacia la izquierda. Las apps están agrupadas por categoría (reciente, juego, audio, video,
imagen, social, etc.) y hay un buscador arriba. Es el lugar donde están **todas** tus apps, aunque no estén en ninguna página.

## 5. Los ajustes del launcher

Abrí el ícono **iOS Launcher** para ver la lista. Cada fila abre su propia pantalla:

| Fila | Qué permite |
|---|---|
| Disposición | Cómo se ordenan los íconos y las páginas |
| Clima | Configurar el widget y la pantalla del clima |
| Vidrio líquido | El efecto de vidrio de los elementos translúcidos |
| Efecto de desenfoque | El desenfoque de fondo |
| Animaciones | Animaciones al abrir y cerrar |
| Fondos de pantalla | Elegir y cambiar el fondo |
| Cambiar el ícono | Reemplazar el ícono de una app |
| Cambiar nombre | Cambiar el nombre que se muestra de una app |
| Biblioteca de aplicaciones | Opciones de la biblioteca |
| Aplicaciones ocultas | Ocultar apps de la pantalla de inicio |
| Make Default Launcher | Elegir este launcher como el de inicio |
| Lanzador de recarga | Pide confirmación y recarga la pantalla de inicio |

La descripción de cada fila sale de su nombre y de lo que hace el código; si una opción se comporta distinto, tiene prioridad
lo que ves en pantalla.

## 6. Tema claro y oscuro

Los íconos tienen versión clara y oscura y cambian solos cuando Android pasa de un tema al otro. Los íconos de Reloj y Calendario
se dibujan en vivo (hora y fecha reales) y mantienen su cara blanca en los dos temas.

## 7. Si algo no anda

- **Un ícono se ve mal o desactualizado:** abrí *Ajustes → Lanzador de recarga* y aceptá.
- **La pantalla de inicio no carga:** detené la app desde los ajustes de Android y volvé a abrirla.
- **La app se cierra:** anotá qué estabas haciendo, mirá `adb logcat` si podés y abrí un *issue* en el repositorio.
- **Aparece la app de Samsung (u otro launcher) en vez de esta:** tu teléfono dejó de usar este launcher como el de inicio;
  repetí el paso 3 de *Empezar*.
