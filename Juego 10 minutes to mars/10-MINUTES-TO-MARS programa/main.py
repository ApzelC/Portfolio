import pygame
from pygame import *
import sys, time, math, random


#MENU  DE INICIO
def escena1(screen):
  while True:
    s.play(3)
    start = (300, 200, 200, 200)
    screen.fill((25, 25, 80))
    screen.blit(fondo, (0, 0))
    texto = myFont.render("10 MINUTES TO MARS", True, (255, 255, 255))
    screen.blit(texto, (68, 80))
    draw.ellipse(screen, (97, 2, 2), start, 0)
    texto2 = myFont2.render("LAUNCH", True, (255, 255, 255))
    screen.blit(texto2, (307, 280))
    for k in event.get():
        if k.type == QUIT: sys.exit()
        if k.type == KEYDOWN and k.key ==K_l:
            return 2 
        if k.type == KEYDOWN and k.key ==K_h:
            return 3    
    
    textoL= myFont5.render("[L]", True, (255, 255, 255))
    screen.blit(textoL, (370, 330))

    rectan = (300, 450, 200, 70)
    draw.rect(screen, (191, 180, 17), rectan ,4)
    texto3 = myFont3.render("Como jugar", True, (191, 180, 17))
    screen.blit(texto3, (310,470))
    textoH= myFont4.render("[H]", True, (191, 180, 17))
    screen.blit(textoH, (385, 497))

    display.flip()
      
#PANTALLA GANASTE
def escena6(screen):
  turbo.stop()
  vic.play()
  while True:
    marte = image.load("planeta3.png")
    marte = transform.scale(marte,(280,280))
    nave = image.load("nave.png")
    nave = transform.scale(nave, (100, 100))
    screen.fill((25, 25, 80))
    screen.blit(fondo, (0, 0))
    screen.blit(marte, (258, 250))
    screen.blit(nave, (323,178))
    screen.blit(bandera,(392,210))
    TextoG2 =  myFont3.render("FELICIDADES, HAS LLEGADO A MARTE!", True, (28, 230, 14))
    screen.blit(TextoG2, (160, 70))
    
    TextoG1 = myFont3.render("Presiona  [ M ]  para volver al menu principal", True, (255, 255, 255))
    screen.blit(TextoG1, (67, 550))

    for h in event.get():
            if h.type == QUIT: sys.exit()
           
            if h.type == KEYDOWN and h.key ==K_m:
              return 1

    display.flip()  

#PANTALLA PERDISTE
def escena5(screen):
  em.play()
  while True:
    screen.fill((25, 25, 80))
    screen.blit(fondo, (0, 0))
    screen.blit(astro, (200,150))
    TextoP =  myFont8.render("PERDISTE", True, (207, 19, 19))
    screen.blit(TextoP, (200, 70))

    TextoR = myFont3.render("Presiona  [ L ]  para reintentar", True, (255, 255, 255))
    screen.blit(TextoR, (180, 500))

    TextoR1 = myFont3.render("Presiona  [ M ]  para volver al menu principal", True, (255, 255, 255))
    screen.blit(TextoR1, (67, 550))

    for h in event.get():
            if h.type == QUIT: sys.exit()
            if h.type == KEYDOWN and h.key ==K_l:
              return 2
            if h.type == KEYDOWN and h.key ==K_m:
              return 1
    
    display.flip()  

#COMO JUGAR
def escena3(screen):
  while True:
    s.play(3)
    screen.fill((0, 0, 0))
    for e in event.get():
      if e.type == QUIT: sys.exit()
      if e.type == KEYDOWN and e.key ==K_SPACE:
            return 1
    screen.blit(how, (0, 0))
    texto4 = myFont4.render("Presiona espacio para regresar al menú principal", True, (191, 180, 17))
    screen.blit(texto4, (200,570))
    display.flip()




#JUEGO
def escena2(screen):
  inicial = time.time()
  textoRespuesta = ""
  P = 0
  y = 455
  x = 350
  m = 100 
  num = 0
  numpreg = ["1", "2" ,"3","4"]
  preg = (random.choice(preguntas)) 
  while True:
    s.stop()
    nave = image.load("nave.png")
    nave = transform.scale(nave, (m, m))
    screen.fill((25, 25, 80))
    screen.blit(fondo, (0, 0))
    screen.blit(tierra, (300,540))
    screen.blit(planeta1, (138, 40))
    screen.blit(nave, (x,y))
    screen.blit(planeta2, (700, 100))
    screen.blit(saturno, (50, 340))
    screen.blit(planeta3, (328, -50))
    screen.blit(sol, (600, 400))
    screen.blit(luna, (320, 482))
    rectan = (100, 150, 600, 200)
    actual = time.time()
    tiempo = actual - inicial
    tiempo = round(tiempo)
    texto = myFont3.render(str(tiempo), True,(0, 0, 0))
    Tt = myFont6.render("Tiempo transcurrido", True, (0, 0, 0))
    screen.blit(Tt, (350,0))
    screen.blit(texto, (395,20))
    if tiempo ==0:
      kj.play()
    if tiempo>=1 and tiempo<5:
      texto9 = myFont7.render("LISTO?", True, (191, 180, 17))
      screen.blit(texto9, (330,100))
    if tiempo>5:
      multilineText(screen, myFont9, preg[P][0],600,130,160)
      draw.rect(screen, (9, 51, 9), (150,300, 100,50),0)
      draw.rect(screen, (9, 51, 9), (350,300, 100,50),0)
      draw.rect(screen, (9, 51, 9), (550,300, 100,50),0)
      textoR11 = myFont9.render(preg[P][1], True,(255, 255, 255))
      textoR12 = myFont9.render(preg[P][2], True,(255, 255, 255))
      textoR13 = myFont9.render(preg[P][3], True,(255, 255, 255))
      screen.blit(textoR11, (190,310))
      screen.blit(textoR12, (390,310))
      screen.blit(textoR13, (590,310))
      r11 = myFont9.render("[ 1 ]", True,(255, 255, 255))
      r12 = myFont9.render("[ 2 ]", True,(255, 255, 255))
      r13 = myFont9.render("[ 3 ]", True,(255, 255, 255))
      screen.blit(r11, (190,330))
      screen.blit(r12, (388,330))
      screen.blit(r13, (586,330))
      numP1 = myFont9.render("de 4", True,(255, 123, 0))
      numP = myFont9.render(numpreg[num], True,(255, 123, 0))
      screen.blit(numP,(130, 130))
      screen.blit(numP1,(150, 130))
      resultado = myFont5.render(textoRespuesta, True, (191, 180, 17))
      salir = myFont10.render("Presiona [ Q ] para salir", True,(207, 19, 19)) 
      screen.blit(salir, (10, 10))
      screen.blit(resultado, (360,455))
      for h in event.get():
        if h.type == QUIT: sys.exit()
        if h.type == KEYDOWN and h.key == K_q:
           return 1
        if h.type == KEYDOWN and h.key == K_1:
          if 1 == preg[P][4]:
            textoRespuesta = "bien"
            P=P+1
            y=y-120
            x=x+11
            m = m - 20
            num= num+1
            turbo.play()
          else:
            return 5
          
        if h.type == KEYDOWN and h.key ==K_2:
          if 2 == preg[P][4]:
            textoRespuesta = "bien"
            P=P+1
            y= y-120
            x=x+11
            m = m - 20
            num = num+1
            turbo.play()
          else:
            return 5
          
        if h.type == KEYDOWN and h.key ==K_3:
          if 3 == preg[P][4]:
            textoRespuesta = "bien"
            P=P+1
            y=y-120
            x=x+11
            m = m - 20
            num= num+1
            turbo.play()
          else:
            return 5

          
      if P>3:
        return 6
    display.flip()

#[]
init()
how = image.load("howtoplay.jpg")
how = transform.scale(how,(800,600))
fondo = image.load("450_1000.jpg")
fondo = transform.scale(fondo, (800, 600))
screen = display.set_mode((800, 600))
cabina = image.load("cabina.jpeg")
cabina = transform.scale(cabina, (800, 600))

#astronautas
astro = image.load("astro.png")
astro = transform.scale(astro, (350, 350))
astroF = image.load("thumbsup.png")
astroF = transform.scale(astroF, (350, 350))
bandera = image.load("ban.png")
bandera = transform.scale(bandera, (60,60))

#planetas
tierra = image.load("tierra.png")
tierra = transform.scale(tierra, (200,200))
planeta1 = image.load("planeta1.png")
planeta1 = transform.scale(planeta1,(50,50))
planeta2 = image.load("planeta2.png")
planeta2 = transform.scale(planeta2,(50,50))
planeta3 = image.load("planeta3.png")
planeta3 = transform.scale(planeta3,(150,150))
sol = image.load("sol.png")
sol = transform.scale(sol,(200,200))
luna = image.load("luna.png")
luna = transform.scale(luna,(30,30))
saturno = image.load("saturno.png")
saturno = transform.scale(saturno, (65,65))

#musique 
pygame.mixer.init()
s = pygame.mixer.Sound("musicfondo.wav")
turbo = pygame.mixer.Sound("turbo.wav")
em = pygame.mixer.Sound("perdiste.wav")
vic = pygame.mixer.Sound("vic.wav")
kj = pygame.mixer.Sound("kj.wav")

#letras
myFont = font.Font("DeathStar.otf", 70)
myFont2 = font.Font("Elemental.ttf", 35)
myFont3 = font.Font("DeathStar.otf", 28)
myFont4 = font.SysFont("Arial", 20)
myFont5 = font.Font("Elemental.ttf", 30)
myFont6 = font.Font("DeathStar.otf", 10)
myFont7 = font.Font("DeathStar.otf", 50)
myFont8 = font.Font("DeathStar.otf", 90)
myFont9 = font.Font("Elemental.ttf", 15)
myFont10 = font.Font("DeathStar.otf", 15)


#\\\\\\\\\\\\\\\\

preguntas1 =[
  ["Una nave espacial viaja 33 mil kilómetros hacia arriba y 77 mil kilómetros a la izquierda ¿cuántos kilómetros recorrió en total?", "100 mil", "110 mil", "120 mil", 2], ["Si en un universo existen 9 galaxias con 7 planetas cada una. ¿Cuántos planetas hay en estas galaxias en total?", "60", "16", "63", 3], ["Un astronauta tiene que limpiar las ventanas de 8 cohetes. Si cada cohete tiene 9 ventanas, ¿Cuántas ventanas limpiará en total?", "17", "72", "81", 2], ["Un astronauta reparte 64 paquetes de comida entre 8 astronautas.¿Cúantos paquetes de comida le tocará a cada uno?", "9", "8", "4", 2]
]

preguntas2 = [
["Si la distancia de un meteorito a la tierra es de 100 kilómetros, y lleva recorridos 80. ¿Cúantos kilómetros le faltan para chocar con la tierra?", "60", "180", "20", 3], ["Si en un universo aparecen 2 estrellas en 1 hora. ¿Cuántas estrellas apareceran en 11 horas?", "22", "20", "32", 1], ["Si un extraterreste visita 4 planetas diariamente. ¿Cúantos planetas habrá visitado en 20 días?", "60", "100", "80", 3] , ["Un extraterreste le da 4 rocas espaciales a su amigo, después su amigo recoge 10 piedras más y lanza la mitad al vacío. ¿Cúantas tendrá en total?", "7", "14", "3", 1]
]                                  

preguntas3 = [
 ["Un astronauta tiene 5 paquetes de comida almacenados, cada uno tiene 10 barritas energéticas, ¿cuantas barritas tiene en total?", "25", "50", "15", 2], ["En una galaxia había 15 planetas. Si 4 planetas fueron destruídos por meteoritos, ¿Cúantos planetas quedan en esa galaxia?", "11", "19", "10", 1], ["Un cohete tiene que llenar su tanque de combustible cada 2 horas. ¿Cúantas veces se tendrá que llenar en 10 horas?", "5", "8", "20", 1], ["Una nueva luna aparece alrededor de un planeta cada 2 días. ¿Cuántas nuevas lunas tendrá en 13 días?", "25", "26", "15", 2]
]

preguntas4 =[
  ["En una base espacial hay 20 trajes de astronauta. Si en el último viaje espacial fueron 12 astronautas, ¿Cuántos trajes quedaron?", "8", "18", "11", 1], ["En un continente hay 7 bases espaciales. Si cada una tiene 5 cohetes, ¿Cuántos cohetes hay en total en ese continente?", "35", "12", "28", 1], ["Un extraterrestre ha visitado 5 planetas, otro extraterrestre ha visitado 2 más que él. ¿Cuántos planetas han visitado en total?", "7", "12", "10", 2], ["Un extraterrestre compra 8 rocas lunares, 2 cajas de 5 semillas de júpiter y 2 bebidas galácticas.¿Cuántos artículos compró en total? ","24", "17", "20", 3]
]

preguntas = [preguntas1, preguntas2, preguntas3, preguntas4]


def multilineText(screen, tipo, texto, width, x, y):
    while len(texto)>0:
        linea = ""
        lin = tipo.render(linea, True, (250,250,250))
        i=0
        espacio = -1
        while lin.get_width()<width and i<len(texto):
            linea = linea + texto[i]
            if texto[i]==" ": espacio = i
            i+=1
            lin = tipo.render(linea, True, (250,250,250))
        if i==len(texto): espacio = i
        lin = tipo.render(linea[:espacio+1], True, (250,250,250))
        texto = texto[espacio+1:]
        screen.blit(lin, (x, y))
        
        y = y + 40




escena = 1
while True:
    if escena == 1:
        escena = escena1(screen)
    elif escena == 2:
        escena = escena2(screen)
    elif escena == 3:
        escena = escena3(screen)
    elif escena == 5:
        escena = escena5(screen)
    elif escena == 6:
        escena = escena6(screen)