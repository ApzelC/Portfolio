//Axel Daniel Corona Ibarra- A01425010
//Proyecto Integrador
//Programación orientada a objetos
#include <iostream>
#include <sstream>
#include <fstream>
#include "Pelicula.h"
#include "Serie.h"
#include "Video.h"
#include <vector>
#define ARCHIVO "series.csv"
#define ARCHIVO2 "peliculas.csv"
using namespace std;

void llena(vector <Video*>&);

int main() {
  int menu;
  double cual;
  double cali;
  int siono;
  int siono2 = 1;
  vector <Video*> videos;
  Video *vid= new Video();
  
  cout<<"----BIENVENIDO A TECFLIX----"<<endl<<"¿Qué deseas hacer?"<<endl<<"1. Ver películas. \n2. Ver series. \n3. Salir. "<<endl;
  cin>>menu;

  if (menu ==1){
   vid = new Pelicula;  
    vid -> imprimir();
    llena(videos);
  
    while(siono2 ==1){
      cout<<endl<<"Quieres calificar alguna pelicula? [si = 1][no = 0]: ";
      cin>>siono;
  
      if(siono ==1){
          cout<<endl<<"Introduce el Número de video a modificar: ";
          cin >>cual;
          if(cual>15){
          Pelicula pepe(videos[cual]->getNombre(),videos[cual]->getGenero(),videos[cual]->getId(),videos[cual]->getDuracion(),videos[cual]->getCalificacion());
    
          cout << endl << endl<<"================"<<endl<<pepe<<endl<<"que calificacion quieres ponerle [1-5]"<<endl;
          cin>>cali;
          if(cali<6){ 
            pepe.setCalificacion(cali);
            videos[cual]->setCalificacion(cali);
            cout << endl << endl<<"================"<<endl<<pepe<<endl;
            cout<<"Quieres calificar otro video? [si = 1][no = 0]:"<<endl;
            cin>>siono2;
          }
          else
            cout<<"Numero inválido"<<endl;
}
      
  }
      else if(siono == 0){
        cout<<"¡Gracias por tu visita!"<<endl;     
        return 0;
         }
  else
    cout<<"Opción no válida"<<endl;

    }
    cout<<"======Gracias======"<<endl;
      for(int i=16; i<videos.size();i++){
        cout<<"==================="<<endl;
        cout<<endl<<"Nombre: "<<videos[i]->getNombre()<<endl;
        cout<<"Género: "<<videos[i]->getGenero()<<endl;
        cout<<"ID: "<<videos[i]->getId()<<endl;
        cout<<"Duración: "<<videos[i]->getDuracion()<<endl;
        cout<<"Calificación: "<<videos[i]->getCalificacion()<<endl;
    }
  cout<<endl<<"Saliendo..."<<endl;
    }
  else if(menu ==2){
   vid = new Serie;  
    vid -> imprimir();
    llena(videos);
    while(siono2 ==1){
      cout<<endl<<"Quieres calificar alguna serie? [si = 1][no = 0]: ";
      cin>>siono;
  
    if(siono ==1){
      cout<<endl<<"Introduce el Número de video a modificar: ";
      cin >>cual;
     cual = cual -1;
      if(cual<16){
      Serie ser(videos[cual]->getNombre(),videos[cual]->getGenero(),videos[cual]->getId(),videos[cual]->getDuracion(),videos[cual]->getCalificacion(),videos[cual]->getTituloEp(),videos[cual]->getEpisodio(),videos[cual]->getTemporada());
      
      cout << endl << endl<<"================"<<endl<<ser<<endl<<"que calificacion quieres ponerle [1-5]"<<endl;
      cin>>cali;
      if(cali<6){ 
      ser.setCalificacion(cali);
      videos[cual]->setCalificacion(cali);
      cout << endl << endl<<"================"<<endl<<ser<<endl;
      cout<<"Quieres calificar otra serie? [si = 1][no = 0]:"<<endl;
      cin>>siono2;
         }
          else
            cout<<"Numero inválido"<<endl;
}
       }
  else if(siono == 0){
    cout<<"¡Gracias por tu visita!"<<endl;
    return 0;
  }

  else
    cout<<"Opción no válida"<<endl;

    }
  cout<<"=========Gracias=========="<<endl;
      for(int i=0; i<16;i++){
     if (videos[i]->getNombre() ==" x"){
       cout<<"====EPISODIO ===="<<endl;
       cout<<"Titulo del episodio:"<< videos[i]->getTituloEp()<<endl;
       cout <<"Número de episodio:"<< videos[i]->getEpisodio()<<endl;
       cout <<"Temporada:"<<videos[i]->getTemporada()<<endl;
       cout <<"Calificacion: "<< videos[i]->getCalificacion()<< endl;
       
    }
    else if(videos[i]->getNombre() !=" x"){
      cout<<"========================"<<endl;
      cout<<"Nombre:"<<videos[i]->getNombre()<<endl;
      cout<<"Género:"<<videos[i]->getGenero()<<endl;
      cout<<"ID:"<<videos[i]->getId()<<endl;
      cout<<"Duración:"<<videos[i]->getDuracion()<<endl;
      cout <<"Temporada:"<<videos[i]->getTemporada()<<endl;
      cout <<"Calificacion: "<< videos[i]->getCalificacion()<< endl;
    
      }
        
    }
    cout<<endl<<"Saliendo..."<<endl;
    }
    
  
  else if(menu ==3){
    cout<<"¡Vuelve pronto!"<<endl;
  }
  else if(menu > 3){
    cout<<"Opción no válida, inténtalo nuevamente."<<endl;
  }
  else if(menu ==3){
    cout<<"¡Gracias, vuelve pronto!"<<endl;
  }
  else{
    cout<<"Opción inválida"<<endl;
  }
return 0;
}

 void llena(vector <Video*> &videos){
  char delimitador = ',';
  string linea;
  ifstream seriesF(ARCHIVO);
  string nombre, genero, id, duracion,tituloEp, episodio, temporada, calificacion;
  string nombre2, genero2, id2, duracion2,tituloEp2, episodio2, temporada2, calificacion2;
  if(!seriesF){
    cout<<"Archivo no encontrado"<<endl;
    cout<<"Verifiquelo e inténtelo de nuevo..."<<endl;
   }
   else{ 
  getline(seriesF, linea);
  while(getline(seriesF, linea)){
    stringstream stream(linea);
    getline(stream, nombre, delimitador);
    getline(stream, genero, delimitador);
    getline(stream, id, delimitador);
    getline(stream, duracion, delimitador);
    getline(stream, tituloEp, delimitador);
    getline(stream, episodio, delimitador);
    getline(stream, temporada, delimitador);
    getline(stream, calificacion, delimitador);

    Serie *se = new Serie(nombre, genero, stoi(id), stoi(duracion),stod(calificacion), tituloEp, stoi(episodio),stoi(temporada));
    videos.push_back(se);

  }
     }
  seriesF.close();

  ifstream PeliF(ARCHIVO2);
  if(!PeliF){
    cout<<"Archivo no encontrado"<<endl;
    cout<<"Verifiquelo e inténtelo de nuevo..."<<endl;
    
   }
  else{ 
    string linea2;
    getline(PeliF, linea2);
    while(getline(PeliF, linea2)){
      stringstream stream(linea2);
     
      getline(stream, nombre2, delimitador);
      getline(stream, genero2, delimitador);
      getline(stream, id2, delimitador);
      getline(stream, duracion2, delimitador);
      getline(stream, calificacion2, delimitador);

      Pelicula *pel= new Pelicula(nombre2, genero2, stoi(id2), stoi(duracion2),stod(calificacion2));
      videos.push_back(pel);

    }
  PeliF.close();
   
  }
}
