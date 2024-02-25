# taller-individual-Electiva2
## Acceso

http://localhost:18080/
##orden

Primero se crea dueño y veterinario
segundo  se crea la mascota con el id por param del dueño y en el body id del veterinario, 
tercero despues creamos carnet ascociandolo al id de la mascota

ORDEN de eliminar:

Permite eliminar DUEÑO y se eliminan sus mascotas y por tanto su carnet asociado
no se puede eliminar veterinario sin antes eliminar Mascota
si se elimina mascota no se elimina el veterinario ni dueño, pero si se elimina el carnet


## Rutas
Para GET nascota:
- /mascotas Retorna todos los elementos guardados en mascotas
- /mascotas/{id} Retorna el elemento con un id especifico

Para GET veterinario:
- /veterinarios Retorna todos los elementos guardados en veterinarios
- /veterinarios/{id} Retorna el elemento con un id especifico

Para GET dueños:
- /dueños Retorna todos los elementos guardados en dueños
- /dueños/{id} Retorna el elemento con un id especifico
- 
  Para GET carnet:
- /carnets Retorna todos los elementos guardados en carnet
- /carnets/{id} Retorna el elemento con un id especifico

Para POST, PUT y DELETE respectivamente
- /mascotas/{id} Envia y guarda los datos ingresados, necesita id del dueño y id de VETERINARIO
EJEMPLO:
  - {
    "data": {
    "idMascota": 5,
    "nombre": "string",
    "raza": "string",
    "veterinarios": [
    {
    "idVeterinario": 1,
    "nombre": "string",
    "telefono": 0
    },
    {
    "idVeterinario": 2,
    "nombre": "string",
    "telefono": 0
    }
    ]
    }

- /mascotas/{id} Actualiza el id con los datos ingresados
- /mascotas/{id} Elimina los datos con el id ingresado


Para POST, PUT y DELETE respectivamente
- /dueños/{id} Envia y guarda los datos ingresados
- /dueños/{id} Actualiza el id con los datos ingresados
- /dueños/{id} Elimina los datos con el id ingresado
- 
  Para POST, y DELETE respectivamente
- /veterinarios/{id} Envia y guarda los datos ingresados
- /veterinarios/{id} Actualiza el id con los datos ingresados
- /veterinarios/{id} Elimina los datos con el id ingresado

Para POST, y DELETE respectivamente
- /carnets/{id} Envia y guarda los datos ingresados, necesita id de MASCOTA
- /carnets/{id} Actualiza el id con los datos ingresados




