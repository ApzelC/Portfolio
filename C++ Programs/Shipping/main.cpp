#include <iostream>
#include "Envio.h"
#include "Paquete.h"
#include "Sobre.h"
using namespace std;
#include <vector>

int main() {
  Envio en;
  en.iniciarEnvio();
  
  vector <Envio*> envio;
  Envio *e;
 
  int cual = 0;  
  double total= 0;
  
  for(int i= 0; i<en.getCuentaEnvios(); i++){
    cout<< "Qué desea enviar? [0 = Paquete] [1 = Sobre]: ";
    cin>>cual;
    
    if(cual==0){ 
      e = new Paquete(); 
      }
    else if (cual == 1){
      e = new Sobre(); 
    }
    
    envio.push_back(e);
    total = total + envio[i] -> calculaCosto();
    envio[i] -> imprimir();
}
cout<<" El costo total de "<<en.getCuentaEnvios()<< " envio(s) es: "<<total<<endl;
return 0;
}