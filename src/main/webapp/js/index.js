
    const nombre = document.getElementById('nombre');
    const facultad = document.getElementById('facultad');
    const regBtn = document.getElementById('regBtn');
    const profesoresContainer = document.getElementById('profesoresContainer');



   const  registrar =()=> {

        let profeObj = {
            id:0,
            nombre:nombre.value,
            facultad:facultad.value

        };
        console.log(JSON.stringify(profeObj));

        //[ara hacer el post]
        let xhr = new XMLHttpRequest();
        //response
        xhr.addEventListener('readystatechange',()=>{
            //readyStatae tiene varios estados el 5 estado es el complete 
            if(xhr.readyState===4){
                console.log(xhr.responseText);
                getAllProfesores();
            }
            
        });
        //request
        xhr.open('POST','http://localhost:8080/FirstApiRest/api/profesores/create');
        xhr.setRequestHeader('Content-Type','application/json');
        //enciamos el objeto en string pero para mandaelo utlizamos JSON.stringfy();
        xhr.send( JSON.stringify(profeObj) );

    };
    regBtn.addEventListener('click',registrar);
    


    const getAllProfesores =()=>{
        
        let xhr = new XMLHttpRequest();
         
        xhr.addEventListener('readystatechange', ()=>{

            if(xhr.readyState === 4){
                let json = xhr.responseText;
                //de json a objeto con el parse!!
                let response = JSON.parse(json);

                console.log(response);
                profesoresContainer.innerHTML='';
                for(let i = 0; i<response.length ; i++){
                
                    let profesorDTO = response[i];
                    let view = new ProfesorView(profesorDTO);
                    view .onDeleteFinish =()=>{
                        profesoresContainer.removeChild(document.getElementById('profesor'+profesorDTO.id));
                    };
                    profesoresContainer.appendChild(view.render());

                }          
                    

            }

        });

        xhr.open('GET','http://localhost:8080/FirstApiRest/api/profesores/all');
        xhr.send();

    };
getAllProfesores();