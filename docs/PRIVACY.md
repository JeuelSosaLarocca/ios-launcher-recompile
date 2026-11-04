# Política de privacidad

Última revisión: 4 de noviembre de 2026 (anuncios eliminados).

> Este texto describe qué hace con tus datos **esta copia recompilada** del launcher, según el código que contiene.
> No es asesoramiento legal. Si alguna vez se distribuye a terceros, hay que revisarlo con un profesional y adaptarlo a las
> normas que correspondan (por ejemplo RGPD, CCPA o las políticas de la tienda donde se publique).

## 1. Qué es y quién responde por los datos

Es una copia personal de un launcher de Android con estilo iOS (el original se llama *iOS Launcher* y es de LuuTinh
Developer). La recompilé a partir de su código decompilado. **No hay servidores propios de este proyecto**: no existe una
cuenta, un registro de usuarios ni un panel donde lleguen datos tuyos. Quien instala y usa la app es el responsable de lo que
ocurre en su propio teléfono.

## 2. Qué datos usa la app y para qué

Todo lo siguiente se procesa **en tu teléfono**. Los usos están deducidos del código y de los permisos declarados.

| Permiso de Android | Para qué se usa | Se envía fuera del teléfono |
|---|---|---|
| Contactos (`READ_CONTACTS`) | Mostrar tus contactos favoritos en los widgets | No |
| Llamadas (`CALL_PHONE`) | Llamar a un contacto favorito desde un widget | No (lo hace la app de teléfono) |
| Calendario (`READ_CALENDAR`) | Mostrar eventos en el widget de calendario | No |
| Ubicación (`ACCESS_FINE_LOCATION`, `ACCESS_COARSE_LOCATION`) | Saber dónde estás para el clima | **Sí**, a la API del clima (ver 3) |
| Almacenamiento y fondo de pantalla (`READ_EXTERNAL_STORAGE`, `WRITE_EXTERNAL_STORAGE`, `SET_WALLPAPER`, `SET_WALLPAPER_HINTS`, `READ_WALLPAPER_INTERNAL`) | Elegir una foto y aplicarla de fondo, y leer el fondo actual | No |
| Lista de apps (`QUERY_ALL_PACKAGES`) | Mostrar tus apps en la pantalla de inicio, la biblioteca y la búsqueda | No |
| Desinstalar (`REQUEST_DELETE_PACKAGES`) | Pedir al sistema que desinstale una app que elijas | No |
| Bluetooth (`BLUETOOTH`) | Mostrar la batería de dispositivos conectados en el widget de batería | No |
| Red (`INTERNET`, `ACCESS_NETWORK_STATE`) | Consultar el clima | Ver 3 |
| Servicios en segundo plano (`FOREGROUND_SERVICE`, `RECEIVE_BOOT_COMPLETED`, `WAKE_LOCK`, `BROADCAST_STICKY`) | Actualizar el clima y recuperar el estado tras reiniciar | No |
| Widgets (`BIND_APPWIDGET`) | Alojar widgets en la pantalla de inicio | No |
| Vibración (`VIBRATE`) | Respuesta táctil | No |

Lo que la app guarda en el teléfono: la disposición de tu pantalla de inicio, una caché de íconos, tus ajustes y los últimos
datos del clima. Se borra al desinstalar la app o al borrar sus datos desde los ajustes de Android.

## 3. Qué sale del teléfono

1. **Clima.** Al actualizar el clima, la app consulta a *Visual Crossing* (`weather.visualcrossing.com`) con la ubicación o la
   ciudad que elegiste. Esa empresa recibe esa consulta y tu dirección IP, y se rige por su propia política.
2. **Anuncios.** Esta copia ya no muestra ni pide anuncios: se quitaron las llamadas de la pantalla de ajustes y del clima,
   los permisos de publicidad (`AD_ID`, `ACCESS_ADSERVICES_*`) y los identificadores de AdMob. Los archivos del SDK de Google
   Mobile Ads siguen dentro del paquete original de bibliotecas, pero el código no los usa ni los inicializa.
3. **Nada más a propósito.** No encontré en la app cuentas, analítica propia ni servicios de estadísticas como Firebase. Pero
   la app incluye bibliotecas de terceros que no revisé línea por línea, así que no puedo garantizar que no haya otras
   conexiones.

El proyecto no vende datos, no hace perfiles y no comparte nada con nadie más.

## 4. Qué puedes controlar

- **Permisos:** concedelos o retiralos en *Ajustes de Android → Apps → iOS Launcher → Permisos*. La app sigue funcionando sin
  ellos, pero los widgets que dependen de cada permiso dejan de funcionar.
- **Datos locales:** *Ajustes de Android → Apps → iOS Launcher → Almacenamiento → Borrar datos*, o desinstalar la app.
- **Clima:** no actives la ubicación para el clima, o elegí una ciudad a mano si la app lo permite.

## 5. Menores

La app no está dirigida a menores de edad ni les pide datos.

## 6. Cambios

Si cambia lo que hace la app con tus datos, se actualiza este documento y su fecha de revisión. El historial queda en el
repositorio.

## 7. Contacto

Para preguntas sobre este documento o sobre esta copia, abrí un *issue* en el repositorio del proyecto.
Para el launcher original, el contacto es su desarrollador, LuuTinh Developer.
