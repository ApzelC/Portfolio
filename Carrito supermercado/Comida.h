#include <iostream>
using namespace std;


//clase comida
class Comida{
  string manzana, carne, galletas, pan;

  public:

  //constructores y destructor
  Comida();
  Comida(string, string, string, string);
  ~Comida();

  //getters
  string getManzana();
  string getCarne();
  string getGalletas();
  string getPan();

  //setters
  void setManzana(string);
  void setCarne(string);
  void setGalletas(string);
  void setPan(string);
  void imprimirComida();
};