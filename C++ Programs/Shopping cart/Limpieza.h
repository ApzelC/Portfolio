#include <iostream>
using namespace std;


//clase Limpieza
class Limpieza{
  string shampoo, jabon, pastaD, desodorante;

  public:

  //constructores y destructor
  Limpieza();
  Limpieza(string, string, string, string);
  ~Limpieza();

  //getters
  string getShampoo();
  string getJabon();
  string getPastaD();
  string getDesodorante();

  //setters
  void setShampoo(string);
  void setJabon(string);
  void setPastaD(string);
  void setDesodorante(string);
  void imprimirLimpieza();
};