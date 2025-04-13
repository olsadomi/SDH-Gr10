# SDH-Gr10 - Projekti 2

Ky projekt implementon dy algoritme enkriptimi/dekriptimi:

1. **Polybius Square Cipher**
2. **Myszkowski Transposition Cipher**

Të dy algoritmet janë implementuar në Java dhe janë krijuar për të demonstruar teknika bazike të enkriptimit/dekriptimit për sigurinë e të dhënave.

## **Udhëzime për Ekzekutimin e Programit**

1. **Klononi Repository-në**  
   Klononi repository-në në kompjuterin tuaj lokal duke përdorur Git:
   ```bash
   https://github.com/olsadomi/SDH-Gr10.git

2. **Hapni Projektin në një IDE**
   Hapni dosjen e projektit në IDE-në tuaj të preferuar (p.sh., IntelliJ IDEA ose VS Code).

3. **Kompiloni dhe Ekzekutoni Programin**
   Për të kompiluar dhe ekzekutuar programin, përdorni komandat e mëposhtme në terminal (sigurohuni që të jeni në dosjen e projektit):
   
   ```bash
   javac src/*.java
   java src.Main
   ```

   Po ashtu, mund ta ekzekutoni programin direkt nga IDE-ja duke klikuar butonin "Run".


   ## **Algoritmet**

### 1. **Polybius Square Cipher**

**Polybius Square Cipher** është një metodë e thjeshtë e enkriptimit që përdor një matricë 5x5 të shkronjave. Çdo shkronjë e mesazhit përfaqësohet nga një çift numrash, që janë koordinatat e rreshtit dhe kolonës në matricë.

### Shembull i Ekzekutimit - Enkriptimi

![Polybius Square Cipher Execution](src/resources/assets/polybius-demo.png)

### 1.1 **Polybius Square Cipher Decryption**

### Shembull i Ekzekutimit - Dekriptimi
![Polybius Square Cipher Execution](src/resources/assets/PolybiusDecrypt.png)


### 2. **Myszkowski Transposition Cipher** 
**Myszkowski Transposition Cipher** është një metodë enkriptimi që përdor një fjalë kyçe me shkronja të përsëritura për të riorganizuar tekstin. 
Teksti vendoset në një tabelë me kolona sipas çelësit, dhe kolonat lexohen në rendin që përcaktohet nga shkronjat e çelësit. 
Shkronjat e njëjta në çelës shkaktojnë që kolonat përkatëse të lexohen në të njëjtën radhë, duke e dalluar këtë metodë nga transpozimet e zakonshme.

#### Hapat për Enkriptimin
1. **Inputi**: Mesazhi që do të kodoni dhe një fjalë kyçe.
2. **Hapi i parë**: Krijo një tabelë me disa kolona që janë të barabarta me gjatësinë e fjalës kyçe.
3. **Hapi i dytë**: Radhit secilën shkronjë të mesazhit sipas pozicionit të shkronjave të fjalës kyçe.
4. **Hapi i tretë**: Shtyp çdo kolonë në radhë, duke formuar mesazhin e koduar.

#### Hapat për Dekriptim
1. **Inputi**: Mesazhi i koduar dhe fjalë kyçe.
2. **Hapi i parë**: Krijo tabelën përkatëse me numërimin e kolonave të bazuar në fjalën kyçe.
3. **Hapi i dytë**: Riorganizo karakteret për të rikthyer mesazhin origjinal sipas pozicioneve të fjalës kyçe.
4. **Hapi i tretë**: Lexo mesazhin e dekoduar nga rreshtat.

### Shembull i Ekzekutimit të Myszkowski Transposition - Enkriptimi dhe Dekriptimi 

![Enkriptim dhe Dekriptim](src/resources/assets/MyszkowskiTransposition.png)
