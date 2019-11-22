package dailyprogrammer;

import java.util.*;

public class Challenge379Taxation {

    public static int tax(int income) {
        // TODO - Implement reading of xml file to get tax layer
        List<TaxLayer> taxList = new ArrayList<>();
        taxList.add(new TaxLayer(10000, 0.0));
        taxList.add(new TaxLayer(30000, 0.1));
        taxList.add(new TaxLayer(100000, 0.25));
        taxList.add(new TaxLayer(-1, 0.4));
        return getTaxFromLayers(taxList, income);
    }


    private static int getTaxFromLayers(List<TaxLayer> taxList, int income) {
        int incomeInLayer = 0;
        int prevLayer = 0;
        int totalTax = 0;
        
        for (TaxLayer layer : taxList) {
            incomeInLayer = getIncomeInLayer(layer.getLayerCap(), prevLayer, income);
            totalTax += Math.floor(incomeInLayer * layer.getTaxPerc());
            prevLayer = layer.getLayerCap();
        }
        return totalTax;
    }


    private static int getIncomeInLayer(int taxLayer, int prevLayer, int income) {
        if (taxLayer >= income || taxLayer == -1) {
            return ((income - prevLayer) > 0) ? income - prevLayer : 0;
        } else {
            return taxLayer - prevLayer;
        }
    }


    public static int overall(float taxRate) {
        // Use binary search
        List<TaxLayer> taxList = new ArrayList<>();
        taxList.add(new TaxLayer(10000, 0.0));
        taxList.add(new TaxLayer(30000, 0.1));
        taxList.add(new TaxLayer(100000, 0.25));
        taxList.add(new TaxLayer(-1, 0.4));

        return findIncomeFromTaxRate(taxList, taxRate);
    }


    private static int findIncomeFromTaxRate(List<TaxLayer> taxList, double targetTaxRate) {
        int prevLayer = 0;
        int totalIncome = 0;
        double prevLayerTaxRate = 0.0;
        double calcTaxRate = 0.0;

        for (TaxLayer layer : taxList) {
            if (targetTaxRate >= layer.getTaxPerc()) {
                calcTaxRate = calcTaxRate * (totalIncome / totalIncome + layer.getLayerCap()
                    + layer.getTaxPerc() * (layer.getLayerCap() / totalIncome + layer.getLayerCap()));
                totalIncome += layer.getLayerCap();
                prevLayer = layer.getLayerCap();
                prevLayerTaxRate = layer.getTaxPerc();
            } else {
                if (layer.getLayerCap() == -1) {
                    return -1;
                } else {
                    return binaryIncomeSearch(totalIncome, layer.getLayerCap(), calcTaxRate, targetTaxRate, layer.getTaxPerc());
                }
            }

            return totalIncome;
        }

        

        return totalIncome;
    }

    
    private static int binaryIncomeSearch(int baseIncome, int topIncome, double baseTaxRate, double targetTaxRate, double topTaxRate) {
        
    }
}


class TaxLayer {
    private int layerCap;
    private double taxPerc;

    public TaxLayer(int layerCap, double taxPerc) {
        this.layerCap = layerCap;
        this.taxPerc = taxPerc;
    }


    public int getLayerCap() {
        return layerCap;
    }


    public double getTaxPerc() {
        return taxPerc;
    }
}