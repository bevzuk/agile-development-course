package ru.unn.agile.Polynomial;

import java.util.ArrayList;
import java.util.List;

public class PolynomialCalculator {

    private PolynomialParser parser = null;
    private PolynomialWriter writer = null;

    public PolynomialCalculator() {
        parser = new PolynomialParser();
        writer = new PolynomialWriter();
    }

    private Term[] simplify(Term[] terms) {
        ArrayList<Term> simplifiedTerms = new ArrayList<Term>();

        for (int i = 0; i < terms.length; i++) {
            boolean isFound = false;
            for (int j = 0; j < simplifiedTerms.size(); j++) {
                if (simplifiedTerms.get(j).degree == terms[i].degree) {
                    simplifiedTerms.get(j).coefficient += terms[i].coefficient;
                    isFound = true;
                    break;
                }
            }
            if (!isFound) {
                simplifiedTerms.add(terms[i]);
            }
        }

        return simplifiedTerms.toArray(new Term[simplifiedTerms.size()]);
    }

    public String add(String summand1, String summand2) {
        Term[] terms1 = parser.parsePolynomial(summand1);
        Term[] terms2 = parser.parsePolynomial(summand2);

        Term[] result = simplify(combineTerms(terms1, terms2));

        return writer.writePolynomial(result);
    }

    private Term[] combineTerms(Term[] terms1, Term[] terms2) {
        Term[] bothTerms = new Term[terms1.length + terms2.length];
        System.arraycopy(terms1, 0, bothTerms, 0, terms1.length);
        System.arraycopy(terms2, 0, bothTerms, terms1.length, terms2.length);
        return bothTerms;
    }

    public String sub(String minuend, String subtrahend) {
        Term[] terms1 = parser.parsePolynomial(minuend);
        Term[] terms2 = parser.parsePolynomial(subtrahend);

        for (int i = 0; i < terms2.length; i++) {
            terms2[i].coefficient *= -1;
        }

        Term[] result = simplify(combineTerms(terms1, terms2));

        return writer.writePolynomial(result);
    }

    public String mul(String multiplier1, String multiplier2) {
        Term[] terms1 = parser.parsePolynomial(multiplier1);
        Term[] terms2 = parser.parsePolynomial(multiplier2);

        ArrayList<Term> product = new ArrayList<Term>();

        for (int i = 0; i < terms1.length; i++) {
            for (int j = 0; j < terms2.length; j++) {
                Term term = new Term(0, 0);
                term.setValues(terms1[i].coefficient * terms2[j].coefficient, terms1[i].degree + terms2[j].degree);
                product.add(term);
            }
        }

        Term[] result = simplify(product.toArray(new Term[product.size()]));

        return writer.writePolynomial(result);
    }
}
