# taller-individual-Electiva2
## Acceso

http://localhost:18080/

orden

Primero se crea dueño y veterinario
segundo  se crea la mascota con el **id por param del dueño** y en el body **id del veterinario**, 
tercero despues creamos carnet ascociandolo al **id de la mascota**

ORDEN de eliminar:

Permite eliminar DUEÑO y se eliminan sus mascotas y por tanto su carnet asociado
no se puede eliminar veterinario sin antes eliminar Mascota
si se elimina mascota no se elimina el veterinario ni dueño, pero si se elimina el carnet


## Rutas
### MASCOTA
Para GET mascota:
- /mascotas Retorna todos los elementos guardados en mascotas
- /mascotas/{id} Retorna el elemento con un id especifico
- /mascotas/getveterinarios/{id} Retorna el los veterinarioque atienden a esa mascota
- /mascotas/raza/{raza} retorna filtro por raza
  
Para POST, PUT y DELETE respectivamente
- /mascotas/{id} Envia y guarda los datos ingresados, necesita id del dueño y id de VETERINARIO
  EJEMPLO:
  ```json
  {
  "idMascota": 1,
  "nombre": "zacha",
  "raza": "beagle",
  "veterinarios": [
    {
      "idVeterinario": 1
    },
  {
  "idVeterinario": 1
  }
  ]
  }

- /mascotas/{id} Actualiza el id con los datos ingresados
- /mascotas/{id} Elimina los datos con el id ingresado

### VETERINARIO
  Para GET veterinario:
  - /veterinarios Retorna todos los elementos guardados en veterinarios
  - /veterinarios/{id} Retorna el elemento con un id especifico
  - /veterinarios/getAnimales/{id} Retorna el las mascotas que atiende ese veterinario
  
  Para POST,PUT y DELETE respectivamente
  - /veterinarios/{id} Envia y guarda los datos ingresados
  Ejemplo:
    ```json
      {
      "idVeterinario": 1,
      "nombre": "Lola Lopez",
      "telefono": 3114543488
      }
  - 
  - /veterinarios/{id} Actualiza el id con los datos ingresados
  - /veterinarios/{id} Elimina los datos con el id ingresado


### DUEÑO
Para GET dueños:
- /dueños Retorna todos los elementos guardados en dueños
- /dueños/{id} Retorna el elemento con un id especifico
- /dueños/nombre/{nombre} Retorna el elemento con un id especifico
Para POST, PUT y DELETE respectivamente
-/dueños/{id} Envia y guarda los datos ingresados
    Ejemplo:
  ```json          
    {
    "id": 1,
    "nombre": "Marta Ramirez",
    "telefono": 3114543484,
    "direcccion": "calle 5"
    }
- /dueños/{id} Actualiza el id con los datos ingresados
- /dueños/{id} Elimina los datos con el id ingresado
  
### CARNET
  Para GET carnet:
- /carnets Retorna todos los elementos guardados en carnet
- /carnets/{id} Retorna el elemento con un id especifico

Para POST y PUT respectivamente
- /carnets/{id} Envia y guarda los datos ingresados, necesita **id de MASCOTA**
  Ejemplo:
    ```json
        {
  "idCarnet": 1,
  "descripcion": "vacunas al dia"
  }
- /carnets/{id} Actualiza el id con los datos ingresados




