package mirrg.helium.math.hydrogen.complex.functions;

import mirrg.helium.math.hydrogen.complex.StructureComplex;

public class Sigmoid
{

	public static final void sigmoid(StructureComplex z, StructureComplex a)
	{
		z.mul(a);
		sigmoid(z);
	}

	public static final void sigmoid(StructureComplex z, double r, double i)
	{
		z.mul(-r, -i);
		Exponential.exp(z);
		z.add(1);
		z.inv();
	}

	/**
	 * <pre>
	 * sigmoid(z) = 1 / (1 + e &circ; -rz)
	 * </pre>
	 */
	public static final void sigmoid(StructureComplex z, double r)
	{
		z.mul(-r);
		Exponential.exp(z);
		z.add(1);
		z.inv();
	}

	/**
	 * <pre>
	 * sigmoid(z) = 1 / (1 + e &circ; -z)
	 * </pre>
	 */
	public static final void sigmoid(StructureComplex z)
	{
		z.neg();
		Exponential.exp(z);
		z.add(1);
		z.inv();
	}

	//

	/**
	 * <pre>
	 * logit(z) = log e z / (1 - z)
	 * </pre>
	 */
	public static final void logit(StructureComplex z, StructureComplex a)
	{
		double ar = a.re;
		double ai = a.im;

		logit(z);
		z.div(ar, ai);
	}

	public static final void logit(StructureComplex z, double r, double i)
	{
		logit(z);
		z.div(r, i);
	}

	/**
	 * <pre>
	 * logit(z) = (1 / r) * log e z / (1 - z)
	 * </pre>
	 */
	public static final void logit(StructureComplex z, double r)
	{
		logit(z);
		z.div(r);
	}

	public static final void logit(StructureComplex z)
	{
		z.div(1 - z.re, -z.im);
		Exponential.ln(z);
	}

}
