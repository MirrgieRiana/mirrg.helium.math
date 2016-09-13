package mirrg.helium.math.hydrogen.complex;

import org.apache.commons.math3.util.FastMath;

/**
 * 最高速で稼働するためにオーバーヘッドを削減した複素数構造体。
 */
public final class StructureComplex
{

	public double re = 0;

	public double im = 0;

	public StructureComplex()
	{

	}

	public StructureComplex(double re, double im)
	{
		this.re = re;
		this.im = im;
	}

	public static final StructureComplex createInstance(double re, double im)
	{
		return new StructureComplex(re, im);
	}

	public final StructureComplex copy()
	{
		return new StructureComplex(re, im);
	}

	//

	public final double getRe()
	{
		return re;
	}

	public final void setRe(double re)
	{
		this.re = re;
	}

	public final double getIm()
	{
		return im;
	}

	public final void setIm(double im)
	{
		this.im = im;
	}

	public final void set(StructureComplex complex)
	{
		this.re = complex.re;
		this.im = complex.im;
	}

	public final void set(double re, double im)
	{
		this.re = re;
		this.im = im;
	}

	public final void setPolar(double abs, double arg)
	{
		this.re = abs * FastMath.cos(arg);
		this.im = abs * FastMath.sin(arg);
	}

	public final void setAbstract(double abs)
	{
		mul(abs / getAbstract());
	}

	public final void setArgument(double arg)
	{
		double arg2 = arg - getArgument();
		mul(
			FastMath.cos(arg2),
			FastMath.sin(arg2));
	}

	//

	public final void add(StructureComplex a)
	{
		this.re += a.re;
		this.im += a.im;
	}

	public final void add(double re, double im)
	{
		this.re += re;
		this.im += im;
	}

	public final void add(double re)
	{
		this.re += re;
	}

	//

	public final void sub(StructureComplex a)
	{
		this.re -= a.re;
		this.im -= a.im;
	}

	public final void sub(double re, double im)
	{
		this.re -= re;
		this.im -= im;
	}

	public final void sub(double re)
	{
		this.re -= re;
	}

	//

	public final void mul(StructureComplex a)
	{
		mul(a.re, a.im);
	}

	/**
	 * <pre>
	 * x = this.re; y = this.im; u = real; v = imaginary;
	 *
	 * (x + yi) * (u + vi)
	 * = xu - yv + xvi + yui
	 * </pre>
	 */
	public final void mul(double re, double im)
	{
		set(
			this.re * re - this.im * im,
			this.re * im + this.im * re);
	}

	public final void mul(double re)
	{
		this.re *= re;
		this.im *= re;
	}

	//

	public final void div(StructureComplex a)
	{
		div(a.re, a.im);
	}

	/**
	 * <pre>
	 * x = this.re; y = this.im; u = real; v = imaginary;
	 *
	 * (x + yi) / (u + vi)
	 * = ((x + yi) / (u + vi)) * ((u - vi) / (u - vi))
	 * = ((x + yi) * (u - vi)) / ((u + vi) * (u - vi))
	 * = (xu + yv + yui - xvi) / (uu + vv)
	 * </pre>
	 */
	public final void div(double re, double im)
	{
		double down = Math.pow(re, 2) + Math.pow(im, 2);
		set(
			(this.re * re + this.im * im) / down,
			(this.im * re - this.re * im) / down);
	}

	public final void div(double re)
	{
		this.re /= re;
		this.im /= re;
	}

	//

	/**
	 * -re - im
	 */
	public final void neg()
	{
		re = -re;
		im = -im;
	}

	/**
	 * re - im
	 */
	public final void con()
	{
		im = -im;
	}

	/**
	 * -re + im
	 */
	public final void negcon()
	{
		re = -re;
	}

	/**
	 * <pre>
	 * x = this.re; y = this.im;
	 *
	 * 1 / (x + yi)
	 * = (1 / (x + yi)) * ((x - yi) / (x - yi))
	 * = (x - yi) / ((x + yi) * (x - yi))
	 * = (x - yi) / (x^2 + y^2)
	 * </pre>
	 */
	public final void inv()
	{
		double down = Math.pow(re, 2) + Math.pow(im, 2);
		set(
			re / down,
			-im / down);
	}

	//

	public final double getAbstract2()
	{
		return FastMath.pow(re, 2) + FastMath.pow(im, 2);
	}

	public final double getAbstract()
	{
		return FastMath.sqrt(getAbstract2());
	}

	public final double getLogAbstract()
	{
		return FastMath.log(getAbstract2()) / 2;
	}

	public final double getArgument()
	{
		return FastMath.atan2(im, re);
	}

}
