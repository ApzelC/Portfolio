//Axel Daniel Corona Ibarra - A01425010
//Actividad integradora 1
// 08/08/22

#include "Fecha.h"
#include "Bitacora.h"
#include <iostream>
#include <fstream>
#include <sstream>
#include <string>
#include <vector>
#include <algorithm>
#include <iterator>
#include <stdlib.h>
using namespace std;
fstream archivoF;

int partition(vector <Bitacora*> &bita, int start, int end) {
  Bitacora* pivot = bita[end];
  int pIndex = start;
  for (int i = start; i < end; i++) {
    if (bita[i]->getIp() <= pivot->getIp()) {
      swap(bita[i], bita[pIndex]);
      pIndex++;
    }
  }
  swap(bita[pIndex], bita[end]);
  return pIndex;
}
//Método quickSort
void quicksort(vector <Bitacora*> &bita, int start, int end) {
  if (start >= end) {
    return;
  }
  int pivot = partition(bita, start, end);
  quicksort(bita, start, pivot - 1);
  quicksort(bita, pivot + 1, end);
}
//Método para buscar una fecha
vector <int> busca(vector<Bitacora*> bita2) {
  vector <int> vec;
  int criterio, indice = 0;
  bool encontre = false;
  string mes,dia,hora;
  Bitacora dato;
  cout<<"Ingrese el mes a buscar: ";
  archivoF<<"Ingrese el mes a buscar: ";
  cin>>mes;
  cout<<endl<<"Ingrese el dia a buscar: ";
  archivoF<<endl<<"Ingrese el dia a buscar: ";
  cin>>dia;
  cout<<endl<<"Ingrese la hora a buscar: ";
  archivoF<<endl<<"Ingrese la hora a buscar: ";
  cin>>hora;
  cout<<endl;
  archivoF<<endl;
  dato.setFecha(Fecha(mes, dia, hora));
  while (indice < bita2.size()) { // el ciclo se va a repetir mientras no se acabe el vector
    if (dato.getFecha().getMes() == bita2[indice]->getFecha().getMes() && dato.getFecha().getDia() == bita2[indice]->getFecha().getDia() && dato.getFecha().getHora() == bita2[indice]->getFecha().getHora() ) {
      vec.push_back(indice);
    }
    else
      cout<<"Fecha no encontrada"<<endl;
    return vec;
    indice++;  
  }
  return vec;
}
//Método para el archivo .txt
void imprimir(){
  archivoF.open("impresion.txt",ios::out);
  if(archivoF.fail()){
    cout<<"Ha ocurrido un error con el archivo, verifiquelo"<<endl;
  }
  archivoF<<"Almacenamiento de resultados"<<endl;
}

int main() {
  vector <int> indice;
  Bitacora o;
  vector <Bitacora*> bita2, bita3;
  vector <Bitacora*> bita;
  imprimir();
  o.llenarBitacora(bita2);
  o.llenarBitacora(bita);
  cout<<"================================================"<<endl;
  archivoF<<"================================================"<<endl;
  //imprimir vector
  for(int i=0; i<bita.size();i++){
    cout<<bita[i]->getFecha().getMes()<<" "<<bita[i]->getFecha().getDia()<<" "<<bita[i]->getFecha().getHora()<<" "<<bita[i]->getIp()<<" "<<bita[i]->getRazon()<<endl;
    archivoF<<bita[i]->getFecha().getMes()<<" "<<bita[i]->getFecha().getDia()<<" "<<bita[i]->getFecha().getHora()<<" "<<bita[i]->getIp()<<" "<<bita[i]->getRazon()<<endl;
  }
  
  cout<<"================================================"<<endl;
  archivoF<<"================================================"<<endl;
  int conta=1;
  int n = bita.size();
  quicksort(bita, 0, n - 1);
  for (int i = 0; i < n; i++) {
    cout<<conta<<". "<<bita[i]->getIp()<<endl;
    archivoF<<conta<<". "<<bita[i]->getIp()<<endl;
    conta++;
  }
  cout <<"=====================7==========================="<< endl<<"Cantidad de registros: "<<conta-1<<" || ";
 archivoF <<"=====================7==========================="<< endl<<"Cantidad de registros: "<<conta-1<<" || ";
  size_t ene = distance(begin(bita), end(bita));
  bool hasDuplicates = false;
  int dupli=0;
  sort(begin(bita), end(bita));
  for (int i = 0; i < n - 1; i++) {
      if (bita[i]->getIp() == bita[i + 1]->getIp()) {
        bita[i]->setRepetido(" R");
        hasDuplicates = true;
        dupli++;
      }
  }
  if (hasDuplicates) {
      o.setDuplicados(dupli); //duplicados
      cout << "La lista contiene "<<dupli<<" repetidos"<<endl;
      archivoF << "La lista contiene "<<dupli<<" repetidos"<<endl;
  } else {
      cout << "La lista no contiene valores repetidos"<<endl;
      archivoF << "La lista no contiene valores repetidos"<<endl;
  }
  if(dupli>0){
    cout<<"=====================8==========================="<<endl;
    archivoF<<"=====================8==========================="<<endl;
    for(int j =0; j<bita.size(); j++){
      if(bita[j]->getRepetido()== " R"){
        cout<<"-> "<<bita[j]->getIp()<<" "<<bita[j]->getRepetido()<<endl;
        archivoF<<"-> "<<bita[j]->getIp()<<" "<<bita[j]->getRepetido()<<endl;
      }
    }
  }
  cout<<"================================================"<<endl;
  archivoF<<"================================================"<<endl;
  indice = busca(bita2); //continucación de la busqueda
  if(indice.size()>0){ 
    for(int i = 0;i<indice.size();i++){
      cout<<"Encontrado en el indice "<<indice[i]+1<<" - "<<bita2[indice[i]]->getFecha().getMes()<<" "<<bita2[indice[i]]->getFecha().getDia()<<" "<<bita2[indice[i]]->getFecha().getHora()<<" "<<bita2[indice[i]]->getIp()<<" "<<bita2[indice[i]]->getRazon()<<endl;
      archivoF<<"Encontrado en el indice "<<indice[i]+1<<" - "<<bita2[indice[i]]->getFecha().getMes()<<" "<<bita2[indice[i]]->getFecha().getDia()<<" "<<bita2[indice[i]]->getFecha().getHora()<<" "<<bita2[indice[i]]->getIp()<<" "<<bita2[indice[i]]->getRazon()<<endl;
    }
  }
  cout<<"================================================"<<endl;
  archivoF<<"==============SIN IPs REPETIDAS==============="<<endl;
  o.llenarBitacora(bita3); //Eliminar los elementos duplicados
  int len = bita3.size();
  for(int i=0; i<len-1; i++){ 
        for(int j=i+1; j<len; j++) {
            if(bita3[i]->getIp() == bita3[j]->getIp()) {
                for(int k=j;k<len-1;k++)
                   swap(bita3[k], bita3[k+1]);
                len--;
                j--;
            }
      }
}
  for(int i=0;i<len;i++){
    cout << bita3[i]->getIp() << endl;
    archivoF << bita3[i]->getIp() << endl;
  }
  cout<<"======================9 y 10========================"<<endl;
  archivoF<<"======================9 y 10========================"<<endl;
  if(dupli>0){ //mostrar elementos duplicados
  cout<<"Número de elementos duplicados: "<<o.getDuplicados()<<endl;
  archivoF<<"Número de elementos duplicados: "<<o.getDuplicados()<<endl;
  for(int j =0; j<bita.size(); j++){
      if(bita[j]->getRepetido()== " R"){
        cout<<bita[j]->getIp()<<endl;
        archivoF<<bita[j]->getIp()<<endl;
      }
    }
  }
  else{
    cout<<"No hay elementos duplicados para mostrar"<<endl;
  }
  cout<<"================================================"<<endl;
  cout<<"Programa finalizado con éxito"<<endl;
  archivoF<<"================================================"<<endl;
  archivoF<<"Programa finalizado con éxito"<<endl;
  return 0;
}
