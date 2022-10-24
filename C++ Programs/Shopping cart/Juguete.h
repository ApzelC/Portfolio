#include <iostream>
using namespace std;


//clase comida
class Juguete{
  string carrito, muñeca, pelota, peluche;

  public:

  //constructores y destructor
  Juguete();
  Juguete(string, string, string, string);
  ~Juguete();

  //getters
  string getCarrito();
  string getMuñeca();
  string getPelota();
  string getPeluche();

  //setters
  void setCarrito(string);
  void setMuñeca(string);
  void setPelota(string);
  void setPeluche(string);
  void imprimirJuguete();
};