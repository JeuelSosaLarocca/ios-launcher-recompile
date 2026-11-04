# Acerca de

## Qué es esto

Una copia **recompilable** de un launcher de Android con estilo iOS, hecha para uso personal. Parte del APK de la app
*iOS Launcher* (`com.luutinhit.launcherios`, versión 8.9.2, código de versión 892), decompilado y corregido hasta que compila.
Cómo está armado y cómo se construye está explicado en el [README](../README.md).

## Qué hace el launcher

- Pantalla de inicio con páginas, dock y carpetas.
- Vista *Hoy* con widgets (clima, batería, calendario, fotos, contactos favoritos).
- Biblioteca de aplicaciones con categorías y buscador.
- Buscador de apps y búsqueda web.
- Aplicaciones ocultas, cambio de ícono y de nombre por app.
- Fondos de pantalla y efectos de desenfoque y de vidrio líquido.

La guía de uso está en [HOW-TO-USE.md](HOW-TO-USE.md) y lo que hace con tus datos, en [PRIVACY.md](PRIVACY.md).

## Qué cambia en esta copia

Idioma español, íconos de iOS 27 en versión clara y oscura que cambian con el tema del sistema, sin el pedido de calificación
ni los enlaces a Play Store, sin la imagen de cabecera ni el menú lateral de los ajustes. La lista completa y los motivos
están en [`app-source/docs/RECOMPILE-NOTES.md`](../app-source/docs/RECOMPILE-NOTES.md).

## Datos técnicos

- Android 5.0 (API 21) o superior; compilada para API 36.
- Solo arquitectura `arm64-v8a`.
- Firma de depuración: no sirve para publicarla en una tienda.

## Créditos y límites

- El launcher original y su código son de **LuuTinh Developer**. Esta copia no tiene relación con su autor.
- "iOS", "iPhone" y los nombres y diseños de las apps de Apple son marcas de Apple Inc.; este proyecto no está afiliado a Apple.
- Los íconos de apps de terceros pertenecen a sus dueños y se usan solo en esta copia personal.
- Las herramientas de construcción (dex2jar, tiny-remapper, ASM, smali, jadx) son proyectos de código abierto con sus propias licencias.
- El repositorio es privado y para uso personal; antes de publicarlo hay que resolver los derechos del código decompilado.
