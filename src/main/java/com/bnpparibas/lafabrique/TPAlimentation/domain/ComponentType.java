package com.bnpparibas.lafabrique.TPAlimentation.domain;

public enum ComponentType {

    EAU("Eau (g/100 g)"),
    PROTEINES("Protéines, N x facteur de Jones (g/100 g)"),
    PROTEINES2("Protéines, N x 6.25 (g/100 g)"),
    GLCUDIES("Glucides (g/100 g)"),
    LIPIDES("Lipides (g/100 g)"),
    SUCRES("Sucres (g/100 g)"),
    FRUCTOSE("Fructose (g/100 g)"),
    GALACTOSE("Galactose (g/100 g)"),
    GLUCOSE("Glucose (g/100 g)"),
    LACTOSE("Lactose (g/100 g)"),
    MALTOSE("Maltose (g/100 g)"),
    SACCHAROSE("Saccharose (g/100 g)"),
    AMIDON("Amidon (g/100 g)"),
    FIBRES("Fibres alimentaires (g/100 g)"),
    POLYOLS("Polyols totaux (g/100 g)"),
    CENDRES("Cendres (g/100 g)"),
    ALCOOL("Alcool (g/100 g)"),
    ACIDES_ORGANIQUES("Acides organiques (g/100 g)"),
    AG_SATURES("AG saturés (g/100 g)"),
    AG_MONO_INSATURES("AG monoinsaturés (g/100 g)"),
    AG_POLY_INSATURES("AG polyinsaturés (g/100 g)"),
    AG_40("AG 4:0, butyrique (g/100 g)"),
    AG_60("AG 6:0, caproïque (g/100 g)"),
    AG_80("AG 8:0, caprylique (g/100 g)"),
    AG_10("AG 10:0, caprique (g/100 g)"),
    AG_120("AG 12:0, laurique (g/100 g)"),
    AG_140("AG 14:0, myristique (g/100 g)"),
    AG_160("AG 16:0, palmitique (g/100 g)"),
    AG_180("AG 18:0, stéarique (g/100 g)"),
    AG_181("AG 18:1 9c (n-9), oléique (g/100 g)"),
    AG_182("AG 18:2 9c,12c (n-6), linoléique (g/100 g)"),
    AG_183("AG 18:3 c9,c12,c15 (n-3), alpha-linolénique (g/100 g)"),
    AG_204("AG 20:4 5c,8c,11c,14c (n-6), arachidonique (g/100 g)"),
    AG_205("AG 20:5 5c,8c,11c,14c,17c (n-3) EPA (g/100 g)"),
    AG_226("AG 22:6 4c,7c,10c,13c,16c,19c (n-3) DHA (g/100 g)"),
    CHOLESTEROL("Cholestérol (mg/100 g)"),
    SEL("Sel chlorure de sodium (g/100 g)"),
    CALCIUM("Calcium (mg/100 g)"),
    CHLORURE("Chlorure (mg/100 g)"),
    CUIVRE("Cuivre (mg/100 g)"),
    FER("Fer (mg/100 g)"),
    IODE("Iode (µg/100 g)"),
    MAGNESIUM("Magnésium (mg/100 g)"),
    MANGANESE("Manganèse (mg/100 g)"),
    PHOSPOHORE("Phosphore (mg/100 g)"),
    POTASSIUM("Potassium (mg/100 g)"),
    SELENIUM("Sélénium (µg/100 g)"),
    SODIUM("Sodium (mg/100 g)"),
    ZINC("Zinc (mg/100 g)"),
    RETINOL("Rétinol (µg/100 g)"),
    BETA("Beta-Carotène (µg/100 g)"),
    VIT_D("Vitamine D (µg/100 g)"),
    VIT_E("Vitamine E (mg/100 g)"),
    VIT_K1("Vitamine K1 (µg/100 g)"),
    VIT_K2("Vitamine K2 (µg/100 g)"),
    VIT_C("Vitamine C (mg/100 g)"),
    VIT_B1("Vitamine B1 ou Thiamine (mg/100 g)"),
    VIT_B2("Vitamine B2 ou Riboflavine (mg/100 g)"),
    VIT_B3("Vitamine B3 ou PP ou Niacine (mg/100 g)"),
    VIT_B5("Vitamine B5 ou Acide pantothénique (mg/100 g)"),
    VIT_B6("Vitamine B6 (mg/100 g)"),
    VIT_B9("Vitamine B9 ou Folates totaux (µg/100 g)"),
    VIT_B12("Vitamine B12 (µg/100 g)")
    ;

    private final String componentWording;

    ComponentType(String componentWording) {
        this.componentWording = componentWording;
    }

    public String getComponentWording() {
        return componentWording;
    }

}
