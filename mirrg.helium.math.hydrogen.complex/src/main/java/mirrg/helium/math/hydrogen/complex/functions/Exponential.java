package mirrg.helium.math.hydrogen.complex.functions;

import org.apache.commons.math3.util.FastMath;

import mirrg.helium.math.hydrogen.complex.StructureComplex;

public class Exponential
{

	/**
	 * <pre>
	 * a = e^log e a
	 *
	 * z^a = (e^log e z)^a
	 *     = e^(a * log e z)
	 * </pre>
	 */
	public static final void pow(StructureComplex z, StructureComplex a)
	{
		log(z);
		z.mul(a);
		exp(z);
	}

	public static final void pow(StructureComplex z, double r, double i)
	{
		log(z);
		z.mul(r, i);
		exp(z);
	}

	public static final void pow(StructureComplex z, double r)
	{
		log(z);
		z.mul(r);
		exp(z);
	}

	/**
	 * <pre>
	 * x = z.r; y = z.i;
	 *
	 * (x + yi)^2 = (x + yi) * (x + yi)
	 *            = xx + xyi + xyi + yiyi
	 *            = xx - yy + 2 * xyi
	 * </pre>
	 */
	public static final void pow2(StructureComplex z)
	{
		z.set(
			FastMath.pow(z.re, 2) - FastMath.pow(z.im, 2),
			2 * z.re * z.im);
	}

	//

	/**
	 * <pre>
	 * a = e^log e a
	 *
	 * a^z = (e^log e a)^z
	 *     = e^(z * log e a)
	 * </pre>
	 */
	public static final void exp(StructureComplex z, StructureComplex a)
	{
		z.mul(
			a.getLogAbstract(),
			a.getArgument());
		exp(z);
	}

	public static final void exp(StructureComplex z, double r, double i)
	{
		z.mul(
			FastMath.log(FastMath.pow(r, 2) + FastMath.pow(i, 2)) / 2,
			FastMath.atan2(i, r));
		exp(z);
	}

	/**
	 * <pre>
	 * x = z.r; y = z.i;
	 * a = e^log e a
	 *
	 * r^z = r^(x + yi)
	 *     = r^x * r^yi
	 *     = r^x * ((e^log e r)^yi)
	 *     = r^x * e^(yi * log e r)
	 *     = r^x * e^(yi * log e r)
	 *     = r^x * (cos(y * log e r) + isin(y * log e r))
	 * </pre>
	 */
	public static final void exp(StructureComplex z, double r)
	{
		double expReal = FastMath.pow(r, z.re);
		double a = z.im * FastMath.log(r);

		z.set(
			expReal * FastMath.cos(a),
			expReal * FastMath.sin(a));
	}

	/**
	 * <pre>
	 * x = z.r; y = z.i;
	 *
	 * e^z = e^(x + yi)
	 *     = e^x * e^yi
	 *     = e^x * (cos(y) + isin(y))
	 * </pre>
	 */
	public static final void exp(StructureComplex z)
	{
		double expReal = FastMath.exp(z.re);

		z.set(
			expReal * FastMath.cos(z.im),
			expReal * FastMath.sin(z.im));
	}

	//

	/**
	 * <pre>
	 * log a z = log e z / log e a
	 * </pre>
	 */
	public static final void log(StructureComplex z, StructureComplex a)
	{
		log(z);
		z.div(
			a.getLogAbstract(),
			a.getArgument());
	}

	public static final void log(StructureComplex z, double r, double i)
	{
		log(z);
		z.div(
			FastMath.log(FastMath.pow(r, 2) + FastMath.pow(i, 2)) / 2,
			FastMath.atan2(i, r));
	}

	public static final void log(StructureComplex z, double r)
	{
		log(z);
		z.div(FastMath.log(r));
	}

	public static final double LOG_E_2 = Math.log(2);

	public static final double LOG_E_5 = Math.log(5);

	public static final double LOG_E_10 = Math.log(10);

	public static final void log2(StructureComplex z)
	{
		log(z);
		z.div(LOG_E_2);
	}

	public static final void log5(StructureComplex z)
	{
		log(z);
		z.div(LOG_E_5);
	}

	public static final void log10(StructureComplex z)
	{
		log(z);
		z.div(LOG_E_10);
	}

	public static final void log(StructureComplex z)
	{
		z.set(
			z.getLogAbstract(),
			z.getArgument());
	}

	public static final void ln(StructureComplex z)
	{
		log(z);
	}

}
