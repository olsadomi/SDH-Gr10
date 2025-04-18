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

-----------------------------------------------------------

   ## **Algoritmet**

### 1. **Polybius Square Cipher**

**Polybius Square Cipher** është një metodë e thjeshtë e enkriptimit që përdor një matricë 5x5 të shkronjave. Çdo shkronjë e mesazhit përfaqësohet nga një çift numrash, që janë koordinatat e rreshtit dhe kolonës në matricë.

### Polybius Square Cipher - Ndërveprimi me Programin në Ekzekutim 
![Polybius Square Cipher Execution](src/resources/assets/PolybiusSquareCipherProgramLook.png)

#### Hapat për Enkriptimin
1. **Inputi**: Mesazhi që do të enkriptohet.
2. **Hapi i parë**: Krijo matricën 5x5 me të gjitha shkronjat e alfabetit (duke bashkuar I/J në një qelizë).
3. **Hapi i dytë**: Për secilën shkronjë të mesazhit (shkronja të mëdha dhe pa hapësira), gjej pozicionin përkatës në matricë në formatin (rresht, kolonë).
4. **Hapi i tretë**: Zëvendëso shkronjat me çiftet e numrave dhe i bashkoni për të krijuar tekstin e enkriptuar.

#### Hapat për Dekriptim
1. **Inputi**:  Teksti i enkriptuar në formën e çifteve numerike.
2. **Hapi i parë**: Përdor të njëjtën matricë 5x5 të përdorur në enkriptim.
3. **Hapi i dytë**: Ndaje tekstin e enkriptuar në çifte numrash (rresht, kolonë).
4. **Hapi i tretë**: Gjej shkronjën përkatëse në matricë për secilin çift numrash dhe i bashkoni për të formuar mesazhin origjinal.


### Shembull i Ekzekutimit të Polybius Square Cipher - Enkriptimi dhe Dekriptimi

![Polybius Square Cipher Execution](src/resources/assets/PolybiusSquareCipherEnc&Dec.png)

---------------------------------------------------------------

### 2. **Myszkowski Transposition Cipher** 
**Myszkowski Transposition Cipher** është një metodë enkriptimi që përdor një fjalë kyçe me shkronja të përsëritura për të riorganizuar tekstin. 
Teksti vendoset në një tabelë me kolona sipas çelësit, dhe kolonat lexohen në rendin që përcaktohet nga shkronjat e çelësit. 
Shkronjat e njëjta në çelës shkaktojnë që kolonat përkatëse të lexohen në të njëjtën radhë, duke e dalluar këtë metodë nga transpozimet e zakonshme.

#### Hapat për Enkriptimin
1. **Inputi**: Mesazhi që do të kodoni dhe një fjalë kyçe.
2. **Hapi i parë**: Krijo një tabelë ku numri i kolonave është i barabartë me numrin e shkronjave të fjalës kyçe.
3. **Hapi i dytë**: Radhit secilën shkronjë të mesazhit sipas pozicionit të shkronjave të fjalës kyçe.
4. **Hapi i tretë**: Shtyp çdo kolonë në radhë, duke formuar mesazhin e koduar.

#### Hapat për Dekriptim
1. **Inputi**: Mesazhi i koduar dhe një fjalë kyçe.
2. **Hapi i parë**: Krijo një tabelë ku numri i kolonave është i barabartë me numrin e shkronjave të fjalës kyçe.
3. **Hapi i dytë**: Riorganizo karakteret për të rikthyer mesazhin origjinal sipas pozicioneve të fjalës kyçe.
4. **Hapi i tretë**: Lexo mesazhin e dekoduar nga rreshtat.

### Shembull i Ekzekutimit të Myszkowski Transposition - Enkriptimi dhe Dekriptimi 

![Enkriptimi dhe Dekriptimi](src/resources/assets/MyszkowskiEncryption&Decryption.png)

-----------------------------------------------------------------

Punuar nga:
   - Mehmet Mehmeti
   - Muhamed Jakupi
   - Natyra Bajgora
   - Olsa Domi
