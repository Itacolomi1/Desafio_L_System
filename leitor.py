import re
arquivo =[]
alfabeto = []
passos = ""
axioma = ""
angulo = ""
regras = []


with open("regras.txt","r") as rkeys:
    arquivo = rkeys.readlines()

for token in arquivo:
    if token[0] == 'A':
        alfabeto = token[4:].split(',')                
    if token[0] == 'B': 
        passos = token[4:]        
    if token[0] == 'C':
        axioma = token        
    if token[0] == 'D':
        angulo = token        
    if token[0] == 'r':
        regras.append(token)     

print(alfabeto)
print("passos: " + passos)
print("axioma: " + axioma)
print("angulo: "+ angulo)
print(regras)

# for token in arquivo:
#     print(token)
