
def printos(surface, text, x, y, color, font):
    text_in_lines = text.split('\n')
    for line in text_in_lines:
        new = font.render(line, 1, color)
        surface.blit(new, (x, y))
        y += new.get_height()
        #y2 += new.get_height2()
 
def arrow(screen, color, x, y, ang):
    pygame.draw.line(screen, color, (x, y), (x + 20*math.cos(math.radians(ang + 150.0)), y - 20*math.sin(math.radians(ang + 150.0))))
    pygame.draw.line(screen, color, (x, y), (x + 20*math.cos(math.radians(ang + 210.0)), y - 20*math.sin(math.radians(ang + 210.0))))

def arrow2(screen, color, x, y, ang):
    pygame.draw.line(screen, color, (x2, y2), (x2 + 20*math.cos(math.radians(ang + 150.0)), y2 - 20*math.sin(math.radians(ang + 150.0))))
    pygame.draw.line(screen, color, (x2, y2), (x2 + 20*math.cos(math.radians(ang + 210.0)), y2 - 20*math.sin(math.radians(ang + 210.0))))

def vector(screen, color, x, y, ang):
    w, z = x + v0*10*math.cos(math.radians(ang)), y - v0*10*math.sin(math.radians(ang))
    x, y, w, z = int(x), int(y), int(w), int(z)
    arrow(screen, color, w, z, ang)
    pygame.draw.line(screen, blue, (x, y), (w, z))

def vector2(screen, color, x2, y2, ang):
    w2, z2 = x2 + v02*10*math.cos(math.radians(ang)), y2 - v02*10*math.sin(math.radians(ang))
    x2, y2, w2, z2 = int(x2), int(y2), int(w2), int(z2)
    arrow2(screen, color, w2, z2, ang)
    pygame.draw.line(screen, red, (x2, y2), (w2, z2))

 
import pygame, math
pygame.init() 
 
size = 1500, 700
width= 1500
height =700
black = (0, 0, 0)
blue = (0, 0, 255)
green = (0, 255, 0)
red = (255, 0, 0)
background = (255, 255, 255)
 
screen = pygame.display.set_mode(size) 
pygame.display.set_caption("SIMULACIÓN") 
 
 
radio = 10
radio2 = 20
#height2 = 800+radio2
x = 800
y = 435#height - radio
x2 = 800
y2 = 435#height - radio2
 
pygame.font.init() 
font = pygame.font.Font(None, 50) #tamaño de las letras
 
clock = pygame.time.Clock()
 
t = 0.0
dt = 0.5
 
v0 = 25.0
v02 = 25.0
a = 1.0
ang = 84.0
ang2 = 96.0
g = 9.81

vx = 0
vy = 0
vx2 = 0
vy2 = 0

volcan = pygame.image.load("volcan.png")
volcan = pygame.transform.scale(volcan, (500, 300))
fondo = pygame.image.load("fondo2.jpg")
fondo = pygame.transform.scale(fondo, (1500, 800))
 
lock = True
lock1 = False
second1 = False
second2 = False

ResAir=True#False#
if (ResAir):
    g=g*2
    v02=v02/2
    v0=v0/2
while 1: 
    screen.blit(fondo, (0, 0))
    for event in pygame.event.get(): 
        if event.type == pygame.QUIT:
            exit()
    teclado = pygame.key.get_pressed()
    if(tuple(set(teclado)) == (0,1) and lock):
        if (teclado[pygame.K_UP]):
            v0 += 1
            v02 += 1
        if (teclado[pygame.K_DOWN]): 
            v0 -= 1
            v02 -= 1
        if (teclado[pygame.K_RIGHT] and v0 < 100): 
            ang -= 1
            ang2 += 1
            if(ang < 0):
                ang = 0
        if (teclado[pygame.K_LEFT] and v0 > 1):
            ang += 1
            ang2 -= 1
            if(ang >= 180):
                ang = 180
        if (teclado[pygame.K_SPACE]):
            x = 200
            y = 0
            lock = False
            lock1 = True
            vy0 = v0*math.sin(math.radians(ang))
            vy02 = v02*math.sin(math.radians(ang2))
    if (teclado[pygame.K_ESCAPE]): 
        exit()
    vx0 = v0*math.cos(math.radians(ang))
    vx02 = v02*math.cos(math.radians(ang2))
    vy = a*t - v0*math.sin(math.radians(ang))
    vy2 = a*t - v02*math.sin(math.radians(ang2))
    if(lock1):
        y = 435 - vy0*t + .5*a*(t**2)
        x = 800 + vx0*t
        y2 = 435 - vy02*t + .5*a*(t**2)
        x2 = 800 + vx02*t
        t += dt
        if(y > (height - radio)):
            y = height - radio
            t = 0
            lock1 = False
            second1 = True
        if (y2 > (height - radio2)):
            y2 = height - radio2
            t = 0
            lock1 = False
            second2 = True
    if(second1) or (second2):
        printos(screen, "Continuar? S/N", 650, 445, black, font)
        if(teclado[pygame.K_s]):
            lock = True
            second1 = False
            second2 = False
            x = 800
            y = 435
            x2 = 800
            y2 = 435
            #x = radio
        elif(teclado[pygame.K_n]):
            exit()
 
    screen.blit(volcan, (548, 400))
    printos(screen, "Posición en x = %d \nPosición en y = %d \nÁngulo de inclinación = %d \nVelocidad inicial = %d"%(x - radio, height - radio - y, ang, v0), 15, 10, black, font)
    pygame.draw.circle(screen, blue, (int(x), int(y)), radio)
    printos(screen, "Posición en x2 = %d \nPosición en y2 = %d \n2° Ángulo de inclinación = %d \n2° Velocidad inicial = %d"%(x2 - radio2, height - radio2 - y2, ang2, v02), 555, 10, black, font)
    pygame.draw.circle(screen, red, (int(x2), int(y2)), radio2)
    vector(screen, blue, x, y, ang)
    pygame.display.flip()
    clock.tick(30)