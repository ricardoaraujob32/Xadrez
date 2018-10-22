/*
 * 
 * 
 * 
 */

package model;

/**
 * Esta classe é a superclasse de todas as peças que suportam movimentos especiais antes do seu primeiro movimento.
 * Subclasses devem usar a interface pública desta classe para manipular seus atributos.
 * 
 * @author Ricardo de Araújo Balduino
 * @version 1.0.0.0
 * @since 1.0.0.0
 */
public abstract class PecaComPrimeiroMovimento extends Peca {
   
    /**
     * Indica se esta peça já foi movida alguma vez
     */
    private boolean primeiroMovimento;
    
    /**
     * 
     */
    public PecaComPrimeiroMovimento() {
        primeiroMovimento = true;
    }

    /**
     * 
     */
    public void setNaoEhPrimeiroMovimento() {
        primeiroMovimento = false;
    }

    /**
     * 
     * @return 
     */
    public boolean isPrimeiroMovimento() {
        return primeiroMovimento;
    }
}
