class ProfesorView {

    //vista de un objto 
    //acciones de un objeto


    //recibe un profesor seria nuestro profesorDTO
    constructor(profesor){
        this.profesor=profesor;
        this.onDeleteFinish = null;
    }

    
    deleteProfesor =()=>{
        let xhr = new XMLHttpRequest();
        xhr.addEventListener('readystatechange',()=>{

            if (xhr.readyState===4){
                    if(this.onDeleteFinish!=null){

                        var response = JSON.parse(xhr.responseText);
                        if(response.message==='operacion Exitosa'){
                            this.onDeleteFinish();
                        }else{
                            alert('no se pudo eliminar');
                        }

                        console.log(xhr.responseText);
                        
                    }
            }
        });
        xhr.open('DELETE','http://localhost:8080/FirstApiRest/api/profesores/delete/'+this.profesor.id);
        xhr.send();

    }





    //vista 
    //como estamos en una clase no necesitamos nombre de variable en el metodo
    render =()=>{
        let componet = document.createElement('div');//aca obtenemos eso <div><div/>
        componet.id = 'profesor'+this.profesor.id;
        componet.className = 'profesorComponet'; //aca se asignamos una propiedad al dic queda asi<div className="profesorComponent"><div/>
        let nombre  = document.createElement('p');//<p><p/>
        let facultad  = document.createElement('small');//<small><small/>
        let delBtn = document.createElement('button');
        delBtn.innerHTML='X';
        delBtn.className='delBtn';

        nombre.innerHTML = this.profesor.nombre; //con esto le damos valor a  cada elemento <p><p/>quedaria asi <p>andres mayor<p/>
        facultad.innerHTML=this.profesor.facultad;//<small>Ingenieria <small/>


        componet.appendChild(nombre);//con esto obtenemos <div>  <p><p/>  <div/>
        componet.appendChild(facultad); //  <div>   <p><p/>  <small><small/>  <div/>
        componet.appendChild(delBtn);

        
        
        //comportamiento 
        delBtn.addEventListener('click',this.deleteProfesor);



        return componet;



    }



}