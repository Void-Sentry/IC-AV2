package main;

import net.sourceforge.jFuzzyLogic.FIS;
import net.sourceforge.jFuzzyLogic.plot.JFuzzyChart;
import net.sourceforge.jFuzzyLogic.rule.Variable;
import net.sourceforge.jFuzzyLogic.rule.Rule;

public class PriceController {

	public static void main(String[] args) {
		
		FIS fis = FIS.load("src/resource/FuzzySupport.fcl", true);
		
        JFuzzyChart.get().chart(fis.getFunctionBlock("Fuzzy"));
		
	    fis.setVariable("lucro_anual", 3);
	    fis.setVariable("lucro_obtido", 7);
	    
	    fis.evaluate();

        Variable preco = fis.getFunctionBlock("Fuzzy").getVariable("preco");
        JFuzzyChart.get().chart(preco, preco.getDefuzzifier(), true);
    
        System.out.println(preco.getValue());
        
        for( Rule r : fis.getFunctionBlock("Fuzzy").getFuzzyRuleBlock("No1").getRules() )
          System.out.println(r);
	}

}