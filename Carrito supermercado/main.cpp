#include <iostream>
#include "Comida.h"
#include "Limpieza.h"
#include "Juguete.h"
using namespace std;
const int TOTAL= 20;

int main(){
  Comida a;
  Limpieza b;
  Juguete c;
  string carrito[TOTAL] ;
  int cantidad1, cantidad2, cantidad3, compra, tipo, seguir;

  int i=0;
  cout<< "-SUPERMERCADO-"<<endl;
  reinicio:
  cout<< "Que quieres comprar?:\n"<< "Productos Disponibles:\n"<<"1. Comida\n2. Limpieza personal\n3. Juguetes"<<endl;
  cout<< "Elige un número:"<<endl;
  cin >> compra;
  if( compra==1){
    cout<< "Que comida quieres comprar?:\n"<< "Comida Disponible:\n"<<"1. manzana: "<<a.getManzana()<<"\n2. carne: "<<a.getCarne()<<"\n3. galletas: "<<a.getGalletas()<<"\n4. pan: "<<a.getPan()<<endl;
    reinicio1:
    cout<<"Elige un tipo de comida:"<<endl;
    cin>> tipo;

    if(tipo==1){
      carrito[i++] =a.getManzana();

    }

    if(tipo==2){
      carrito[i++] =a.getCarne();
    }

    if(tipo==3){
      carrito[i++] =a.getGalletas();
    }

    if(tipo==4){
      carrito[i++] =a.getPan();
    }

    if(tipo>4){
      cout<<"Ingrese un número válido\n"<<endl;
      goto reinicio1;
    }

    cout<<"Cuanta comida quieres comprar:"<<endl;
    cin>>cantidad1; 
    cout<<"Has comprado: "<<cantidad1<<" "<<"Productos"<<endl;
    reinicio7:
    cout<<"quieres comprar algo más?"<<endl<<"1, Si\n2. No"<<endl;
    cin>>seguir;
    if(seguir==1){
      goto reinicio;
    }
    if(seguir==2){
      cout<<"Gracias por su visita, vuelva pronto :)"<<endl;
      cout<<"-Ticket-"<<endl;
    for(int a=0;a<TOTAL; a++){
      if(carrito[a]!="")
        cout<<carrito[a]<<endl;
    }
    return 0;
    }

    if(seguir>2){
      goto reinicio7;
    }
}
  
  if(compra==2){
    cout<< "Que producto de limpieza personal quieres comprar?:\n"<< "Productos de limpieza Disponibles:\n"<<"1. shampoo: " <<b.getShampoo()<<"\n2. jabón: "<<b.getJabon()<<"\n3. pasta dental: "<<b.getPastaD()<<"\n4. desodorante: "<<b.getDesodorante()<<endl;
    reinicio2:
    cout<<"Elige un tipo de producto de limpieza:"<<endl;
    cin>> tipo;


    if(tipo==1){
      carrito[i++] =b.getShampoo();

    }
    if(tipo==2){
      carrito[i++] =b.getJabon();

    }
    if(tipo==3){
      carrito[i++] =b.getPastaD();

    }
    if(tipo==4){
      carrito[i++] =b.getDesodorante();

    }
    if(tipo>4){
      cout<<"Ingrese un número válido\n"<<endl;
    goto reinicio2;
    }

    cout<<"Cuantos productos de limpieza quieres comprar:"<<endl;
    cin>>cantidad2;
    cout<<"Has comprado: "<<cantidad2<<" "<<"Productos"<<endl;
    reinicio6:
    cout<<"quieres comprar algo más?"<<endl<<"1, Si\n2. No"<<endl;
    cin>>seguir;
    if(seguir==1){
      goto reinicio;
    }
    if(seguir==2){
      cout<<"Gracias por su visita, vuelva pronto :)"<<endl;
      cout<<"-Ticket-"<<endl;
      for(int a=0;a<TOTAL; a++){
        if(carrito[a]!="")
          cout<<carrito[a]<<endl;
          }
      return 0;
      } 

    if(seguir>2){
      goto reinicio6;
      }
  }


  if(compra==3){
    cout<< "Que juguete quieres comprar?:\n"<< "Juguetes Disponibles:\n"<<"1. carrito: "<<c.getCarrito()<<"\n2. muñeca: "<<c.getMuñeca()<<"\n3. pelota: "<<c.getPelota()<<"\n4. peluche: "<<c.getPeluche()<<endl;
    reinicio3:
    cout<<"Elige un tipo de juguete:"<<endl;
    cin>> tipo;

    if(tipo==1){
      carrito[i++] =c.getCarrito();

    }
    if(tipo==2){
      carrito[i++] =c.getMuñeca();

    }
    if(tipo==3){
      carrito[i++] =c.getPelota();

    }
    if(tipo==4){
        carrito[i++] =c.getPeluche();
      }
    if(tipo>4){
      cout<<"Ingrese un número válido\n"<<endl;
      goto reinicio3;
    }
    cout<<"Cuantos juguetes quieres comprar:"<<endl;
    cin>>cantidad3;

    cout<<"Has comprado: "<<cantidad3<<" "<<"Productos"<<endl;
    reinicio5:
    cout<<"quieres comprar algo más?"<<endl<<"1, Si\n2. No"<<endl;
    cin>>seguir;
    if(seguir==1){
      goto reinicio;
    }
    if(seguir==2){
      cout<<"Gracias por su visita, vuelva pronto :)"<<endl;
      cout<<"-Ticket-"<<endl;
    
    for(int a=0;a<TOTAL; a++){
      if(carrito[a]!="")
        cout<<carrito[a]<<endl;
    } 

      return 0;
    }

    if(seguir>2){
      goto reinicio5;
    }
  }
  if(compra>3){

    cout<<"Ingrese un número válido\n"<<endl;
    goto reinicio;
  }
}