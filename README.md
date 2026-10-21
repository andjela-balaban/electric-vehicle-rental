# ⚡ ePJ2 - Sistem za simulaciju i upravljanje iznajmljivanjem električnih vozila (e-Mobility)

## 📖 O projektu

**ePJ2 - eMobility** je kompleksan softverski sistem za simulaciju i upravljanje radom kompanije koja se bavi iznajmljivanjem električnih prevoznih sredstava (električni automobili, električni bicikli i električni trotineti).

Simulacija prati dinamičko kretanje vozila unutar grada koji je modelovan kao **20x20 koordinatna mreža**. Grad je podijeljen na **užu gradsku zonu** (centar) i **širu gradsku zonu**. Sistem prati bateriju vozila, registruje kvarove, automatski generiše račune sa popustima, evidentira dnevne i zbirne finansijske rezultate, te serijalizuje vozila sa najvećim finansijskim gubicima.

---

## ✨ Ključne funkcionalnosti

### 1. 🗺️ 2D Simulacija na mapi grada (20x20)
- Grad je predstavljen matricom dimenzija **20 x 20**.
- **Uža gradska zona** prostire se od koordinata `(5,5)` do `(14,14)`.
- Vozila se u realnom vremenu kreću kroz matricu u posebnim radnim nitima (multithreading), pri čemu se na grafičkom interfejsu prikazuju odgovarajuće ikone automobila, bicikala i trotineta.
- Klikom na bilo koje polje na mapi prikazuju se trenutne informacije o vozilu koje se na njemu nalazi (ID, model, nivo baterije, trenutni korisnik).

### 2. 🚗 Vozni park (Električna prevozna sredstva)
Sva prevozna sredstva nasljeđuju apstraktnu klasu `PrevoznoSredstvo` koja implementira `Serializable`:
- **Električni automobil (`ElektricniAutomobil`)**:
  - Podaci: ID, proizvođač, model, cijena nabavke, datum nabavke, tekstualni opis.
  - Kapacitet: do 5 putnika.
  - Za iznajmljivanje je obavezna validna vozačka dozvola korisnika.
- **Električni bicikl (`ElektricniBicikl`)**:
  - Podaci: ID, proizvođač, model, cijena nabavke, domet/autonomija baterije (km).
  - Kapacitet: 1 putnik.
- **Električni trotinet (`ElektricniTrotinet`)**:
  - Podaci: ID, proizvođač, model, cijena nabavke, maksimalna brzina (km/h).
  - Kapacitet: 1 putnik.

### 3. 👤 Korisnici i identifikacija
- Korisnici mogu biti **domaći državljani** (identifikacija ličnom kartom) ili **strani državljani** (identifikacija pasošem).
- Prilikom iznajmljivanja automobila provjerava se posjedovanje i podaci vozačke dozvole.
- Ugrađen je mehanizam slučajnog generisanja profila korisnika (`KorisnikGenerator`).

### 4. 🧾 Iznajmljivanja i automatski obračun računa
- Iznajmljivanja se učitavaju iz CSV datoteke i sortiraju hronološki.
- Obračun cijene uzima u obzir:
  - Baznu tarifu po jedinici (`AUTO_UNIT_CIJENA = 15 KM`, `BICIKL_UNIT_CIJENA = 10 KM`, `TROTINET_UNIT_CIJENA = 8 KM`).
  - Pređenu distancu u užem dijelu grada (`DISTANCA_UZI_DIO = 3`) i širem dijelu (`DISTANCA_SIRI_DIO = 2`).
  - **Akcijski popust (promocija)**: 20% popusta za vožnju unutar užeg dijela grada.
  - **Popust lojalnosti**: Svako 10. iznajmljivanje ostvaruje 10% popusta.
- Po završetku svake vožnje, u folder `RACUNI/` automatski se kreira formatiran tekstualni račun sa svim stavkama i podacima o ruti i korisniku.

### 5. 🛠️ Simulacija kvarova i troškovi održavanja
- Tokom vožnje postoji mogućnost nastanka kvara (`KvarGenerator`).
- Ako dođe do kvara, vožnja se prekida, bilježe se vrijeme i opis kvara.
- Trošak popravke se automatski obračunava kao procenat od nabavne cijene:
  - Automobili: `7%` od nabavne cijene.
  - Bicikli: `4%` od nabavne cijene.
  - Trotineti: `2%` od nabavne cijene.

### 6. 📊 Poslovni rezultati i serijalizacija gubitaka
- **Dnevni i sumarni izvještaji**: Ukupni prihodi, odobreni popusti, troškovi popravki i održavanja, troškovi poslovanja, porez i krajnji neto profit kompanije.
- **Najveći gubici**: Sistem proračunava koja su vozila ostvarila najveći finansijski minus i serijalizuje ih u binarnu datoteku `najveciGubitak.ser`.
- Deserijalizacija i vizuelni pregled vozila sa najvećim gubitkom omogućeni su direktno kroz GUI.

### 7. 🖥️ Grafički korisnički interfejs (JavaFX)
- **`SceneDobrodosli`**: Glavni meni i pokretanje simulacije.
- **`SceneSimulacijaKompanije`**: Interaktivna 20x20 mapa grada sa prikazom kretanja, datumom/vremenom i selekcijom vozila.
- **`ScenePrikazPrevoznihSredstava`**: Prikaz cjelokupne flote sa mogućnošću filtriranja (automobili, bicikli, trotineti) i detaljima.
- **`ScenePrikazKvarova`**: Pregled svih incidenata, vremena nastanka i troškova popravke.
- **`ScenePrikazRezultataPoslovanja`**: Dnevni i zbirni finansijski bilans.
- **`ScenePrikazNajveciGubici`**: Prikaz deserijalizovanih vozila sa najvećim gubicima i detaljnim metrikama.

---

## 📁 Struktura projekta

Projekat je organizovan u dva modularna Java projekta:

```
PROJEKTNI_ZADATAK_2024_andjelabalaban/
├── .gitignore                                 # Git pravila ignorisanja build/IDE fajlova
├── README.md                                  # Dokumentacija projekta
│
├── PROJEKTNI_ZADATAK_2024/                    # Core biblioteka i poslovna logika
│   ├── podaciZaSimulaciju/                    # Ulazne CSV datoteke
│   │   ├── PJ2 - projektni zadatak 2024 - Prevozna sredstva.csv
│   │   ├── PJ2 - projektni zadatak 2024 - Iznajmljivanja.csv
│   │   └── PJ2 - projektni zadatak 2024 odbrana - Iznajmljivanja.csv
│   ├── RACUNI/                                # Direktorijum za generisane račune (.txt)
│   ├── serijalizacijaNajveciGubitak/          # Direktorijum za serijalizaciju (najveciGubitak.ser)
│   ├── simulacioniParametri.txt               # Konfiguracioni fajl sa parametrima rada
│   └── src/
│       ├── module-info.java                   # Deklaracija modula i export paketa
│       └── org/unibl/etf/
│           ├── kompanija/                     # Kompanija, Iznajmljivanje, Racun, Exception klase
│           ├── korisnik/                      # Korisnik, Dokument (Pasos, LicnaKarta, VozackaDozvola)
│           ├── korisnikgenerator/             # Generator testnih korisnika
│           ├── prevoznasredstva/              # PrevoznoSredstvo, Auto, Bicikl, Trotinet
│           ├── prevoznasredstvagenerator/     # Generator prevoznih sredstava
│           ├── test/                          # Test konzolna klasa
│           └── util/                          # Loader (CSV), SimulacioniParametri, KvarGenerator, Util
│
└── GUI_PJ2/                                   # JavaFX korisnički interfejs
    ├── projektni_slike/                       # Slike i ikone za automobile, bicikle, trotinet, mapu
    └── src/
        ├── module-info.java                   # JavaFX modul definicije i zavisnost na PROJEKTNI_ZADATAK_2024
        └── application/
            ├── Main.java                      # JavaFX Application ulazna tačka
            ├── IzvrsavacSimulacije.java       # Kontrola pozadinske niti simulacije
            ├── SceneController.java           # Kontroler početnog menija
            ├── SimulationSceneController.java # Glavni kontroler 20x20 mape i simulacije
            ├── PrikazPrevoznihSredstavaController.java
            ├── KvaroviController.java
            ├── RezultatiPoslovanjaController.java
            ├── NajveciGubiciController.java
            ├── InformacijeController.java
            ├── application.css                # CSS stilizacija JavaFX elemenata
            └── *.fxml                         # FXML šabloni korisničkih interfejsa
```

---

## ⚙️ Konfiguracioni parametri

Ponašanje simulacije u potpunosti se konfiguriše preko datoteke `PROJEKTNI_ZADATAK_2024/simulacioniParametri.txt`:

| Parametar | Podrazumijevano | Opis |
|---|---|---|
| `SIRINA_GRADA`, `DUZINA_GRADA` | `20`, `20` | Dimenzije koordinatne mreže grada |
| `POCETAK_UZI_X`, `KRAJ_UZI_X` | `5`, `14` | Granice užeg dijela grada po X osi |
| `POCETAK_UZI_Y`, `KRAJ_UZI_Y` | `5`, `14` | Granice užeg dijela grada po Y osi |
| `AUTO_UNIT_CIJENA` | `15` | Cijena po jedinici za automobile (KM) |
| `BICIKL_UNIT_CIJENA` | `10` | Cijena po jedinici za bicikle (KM) |
| `TROTINET_UNIT_CIJENA` | `8` | Cijena po jedinici za trotinet (KM) |
| `DISTANCA_UZI_DIO` | `3` | Koeficijent distance za uži dio grada |
| `DISTANCA_SIRI_DIO` | `2` | Koeficijent distance za širi dio grada |
| `POPUST` | `0.9` | Popust na svako 10. iznajmljivanje (10%) |
| `POPUST_PROMOCIJA` | `0.8` | Promotivni popust za uži dio grada (20%) |
| `KOEFICIJENT_POPRAVKE_AUTOMOBIL` | `0.07` | 7% od cijene automobila za popravku |
| `KOEFICIJENT_POPRAVKE_BICIKL` | `0.04` | 4% od cijene bicikla za popravku |
| `KOEFICIJENT_POPRAVKE_TROTINET` | `0.02` | 2% od cijene trotineta za popravku |
| `VJEROVATNOCA_DA_JE_KORISNIK_STRANAC` | `40` | Procenat vjerovatnoće za stranog državljanina |
| `PAUZA_NAREDNI_DAN` | `10000` | Pauza između simulacije dana (ms) |
| `PAUZA_NAREDNI_SAT` | `3000` | Pauza između simulacije sati (ms) |

---

## 🧰 Korištene tehnologije i koncepti

- **Objektno-orijentisano programiranje (OOP)**: Apstrakcija, enkapsulacija, polimorfizam i višestruko nasljeđivanje tipova preko interfejsa.
- **JavaFX & FXML**: Modularni GUI, deklarativno definisanje interfejsa pomoću FXML datoteka i SceneBuilder-a uz CSS stilizaciju.
- **Konkurentno programiranje (Multithreading)**: Pozadinske niti (`Thread`, `Runnable`) za nezavisno kretanje vozila, protok vremena i sinhronizovano osvježavanje grafičkog korisničkog interfejsa putem `Platform.runLater()`.
- **Rukovanje tokovima i datotekama (Java I/O)**:
  - Učitavanje i parsiranje konfiguracionih i CSV fajlova (`BufferedReader`, `FileReader`).
  - Dinamičko formatiranje i kreiranje tekstualnih računa (`PrintWriter`, `FileWriter`).
- **Objektna serijalizacija (Java Serialization)**: Čuvanje i rekonstrukcija stanja objekata voznog parka sa najvećim gubicima (`ObjectOutputStream` i `ObjectInputStream`).
- **Java Module System (JPMS)**: Modularizacija aplikacije (`module-info.java`) sa eksplicitnim kontrolama zavisnosti i eksporta paketa.
- **Kolekcije i Generici**: `HashMap`, `TreeMap`, `ArrayList`, sortiranje pomoću `Comparator`-a i `Comparable` interfejsa.
- **Custom Exceptions**: Specifične klase izuzetaka (`KoordinataVanOpsegaGradaException`, `VoziloVecIznajmljenoException`, `VoziloNePostojiUListiPrevoznihSredstavaException`).

---

## 🚀 Uputstvo za pokretanje

### Preduslovi
1. **Java Development Kit (JDK)**: Verzija 19 ili novija (preporučeno JDK 19+).
2. **JavaFX SDK**: Verzija kompatibilna sa instaliranim JDK-om (npr. JavaFX 19+ SDK).
3. **Eclipse IDE** (sa instaliranim e(fx)clipse dodatkom ili podešenim JavaFX User Library).

### Uvoz i konfiguracija u Eclipse IDE

1. **Kloniranje repozitorijuma**:
   ```bash
   git clone https://github.com/andjela-balaban/electric-vehicle-rental.git
   ```

2. **Uvoz u Eclipse**:
   - Otvorite Eclipse IDE.
   - Idite na `File` -> `Import...` -> `General` -> `Existing Projects into Workspace`.
   - Odaberite korijenski folder repozitorijuma.
   - Označite oba prepoznata projekta:
     - `PROJEKTNI_ZADATAK_2024`
     - `GUI_PJ2`
   - Kliknite na **Finish**.

3. **Podešavanje JavaFX biblioteke (ukoliko je potrebno)**:
   - Desni klik na projekat `GUI_PJ2` -> `Build Path` -> `Configure Build Path...`.
   - Pod tabom **Libraries**, dodajte vaš lokalni JavaFX SDK (npr. pod **Modulepath** -> *Add Library* -> *User Library* sa preuzetim JavaFX jar datotekama).

4. **Podešavanje VM argumenata pri pokretanju**:
   - Desni klik na `GUI_PJ2/src/application/Main.java` -> `Run As` -> `Run Configurations...`.
   - Idite na tab **Arguments**, a u polje **VM arguments** unesite:
     ```bash
     --module-path "/putanja/do/javafx-sdk/lib" --add-modules javafx.controls,javafx.fxml,javafx.graphics,javafx.base
     ```
     *(Zamijenite `/putanja/do/javafx-sdk/lib` sa stvarnom putanjom do vašeg `lib` foldera u JavaFX SDK-u).*
   - Kliknite na **Apply**, a zatim na **Run**.
   