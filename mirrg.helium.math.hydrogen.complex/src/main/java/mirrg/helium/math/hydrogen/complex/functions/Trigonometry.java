package mirrg.helium.math.hydrogen.complex.functions;

import org.apache.commons.math3.util.FastMath;

import mirrg.helium.math.hydrogen.complex.StructureComplex;

// TODO asin系列
public class Trigonometry
{

	public static final void sin(StructureComplex z)
	{
		z.set(
			FastMath.sin(z.re) * FastMath.cosh(z.im),
			FastMath.cos(z.re) * FastMath.sinh(z.im));
	}

	public static final void cos(StructureComplex z)
	{
		z.set(
			FastMath.cos(z.re) * FastMath.cosh(z.im),
			-FastMath.sin(z.re) * FastMath.sinh(z.im));
	}

	public static final void sinh(StructureComplex z)
	{
		z.set(
			FastMath.sinh(z.re) * FastMath.cos(z.im),
			FastMath.cosh(z.re) * FastMath.sin(z.im));
	}

	public static final void cosh(StructureComplex z)
	{
		z.set(
			FastMath.cosh(z.re) * FastMath.cos(z.im),
			FastMath.sinh(z.re) * FastMath.sin(z.im));
	}

	public static final void tan(StructureComplex z)
	{
		double real = 2.0D * z.re;
		double imaginary = 2.0D * z.im;
		double down = FastMath.cos(real) + FastMath.cosh(imaginary);

		z.set(
			FastMath.sin(real) / down,
			FastMath.sinh(imaginary) / down);
	}

	public static final void tanh(StructureComplex z)
	{
		double real = 2.0D * z.re;
		double imaginary = 2.0D * z.im;
		double down = FastMath.cosh(real) + FastMath.cos(imaginary);

		z.set(
			FastMath.sinh(real) / down,
			FastMath.sin(imaginary) / down);
	}

}
