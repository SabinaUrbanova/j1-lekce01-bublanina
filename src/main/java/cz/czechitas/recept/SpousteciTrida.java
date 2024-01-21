package cz.czechitas.recept;

import cz.czechitas.recept.naradi.ElektrickaTrouba;
import cz.czechitas.recept.naradi.Miska;
import cz.czechitas.recept.naradi.Mixer;
import cz.czechitas.recept.naradi.PlechNaPeceni;
import cz.czechitas.recept.naradi.Vaha;
import cz.czechitas.recept.suroviny.Cukr;
import cz.czechitas.recept.suroviny.Maslo;
import cz.czechitas.recept.suroviny.Mouka;
import cz.czechitas.recept.suroviny.Ovoce;
import cz.czechitas.recept.suroviny.PrasekDoPeciva;
import cz.czechitas.recept.suroviny.Vajicka;

public class SpousteciTrida {

  public static void main(String[] args) {
    Miska cervenaMiska;
    Miska zlutaMiska;
    Mixer mixer;
    Vaha kuchynskaVaha;
    PlechNaPeceni plech;
    ElektrickaTrouba trouba;
    Vajicka vajicka;

    Ovoce ovoce;
    Maslo maslo125g;
    Mouka pytlikMouky;
    Cukr pytlikCukru;
    PrasekDoPeciva prasekDoPeciva;

    cervenaMiska = new Miska("cervenaMiska");
    zlutaMiska = new Miska("zlutaMiska");
    mixer = new Mixer("mixer");
    kuchynskaVaha = new Vaha("vaha");
    plech = new PlechNaPeceni("plech");
    trouba = new ElektrickaTrouba("trouba");

    vajicka = new Vajicka("vajicka");
    ovoce = new Ovoce("ovoce");
    maslo125g = new Maslo("maslo125g");
    pytlikMouky = new Mouka("pytlikMouky");
    pytlikCukru = new Cukr("pytlikCukru");
    prasekDoPeciva = new PrasekDoPeciva("prasekDoPeciva");

    //---------------------------------------------------------------------
    //1.Smíchejte vajíčka a cukr
    while (cervenaMiska.getPocetVajec()<4) { //este mozem osetrit, ked ich bude viac
      cervenaMiska.nalozSiJedenKus(vajicka);
    }
    cervenaMiska.nalozSiCelyObsah(pytlikCukru);
    cervenaMiska.setDobreZamichane();
    //2.Přidejte máslo a dobře zamíchejte
    cervenaMiska.nalozSiCelyObsah(maslo125g);
    cervenaMiska.setDobreZamichane();
//    3.Přisypte 250 g mouky (pozor, pytlík mouky má 1 kg)
//    Budeme potřebovat vynulovanou váhu s prázdnou miskou.
//    Miska si může vzít trochu mouky, zvážit se, a pokud je to víc než 250 g, zase trochu mouky ubrat.
//    Pokud méně, znovu přidat. A tak pořád dokola, dokud nebude mít správné množství.
    kuchynskaVaha.vynulujSeS(zlutaMiska);

    while (kuchynskaVaha.zjistiHmotnost(zlutaMiska) != 250) {
      if (kuchynskaVaha.zjistiHmotnost(zlutaMiska)< 250) {
        zlutaMiska.nalozSiTrochu(pytlikMouky);
      } else {
        zlutaMiska.vylozSiTrochu();
      }
    }

    cervenaMiska.nalozSiObsahJineMisky(zlutaMiska);
//  4.Nakonec do těsta přidejte prášek do pečiva
    cervenaMiska.nalozSiCelyObsah(prasekDoPeciva);
    cervenaMiska.setDobreZamichane();
    plech.preberSiObsah(cervenaMiska);
//  5.Před vložením do trouby posypte kousky ovoce
    for (int i=0; i<50; i++) {
      plech.posypSeKusem(ovoce);
    }
//  6.Vložte do předehřáté trouby a pečte 25 minut na 180 stupnu
//
    trouba.zapniSe(180);
    trouba.nechejPect(5);
    trouba.vlozSiDovnitr(plech);
    trouba.nechejPect(25);
    trouba.vypniSe();
    trouba.vyndejObsahVen();

  }

}
