package mirrg.helium.math.hydrogen.complex.functions;

import mirrg.helium.math.hydrogen.complex.StructureComplex;

@Deprecated
public class Arithmetic
{

	@Deprecated
	public static final void add(StructureComplex z, StructureComplex a)
	{
		z.add(a);
	}

	@Deprecated
	public static final void add(StructureComplex z, double r, double i)
	{
		z.add(r, i);
	}

	@Deprecated
	public static final void add(StructureComplex z, double r)
	{
		z.add(r);
	}

	//

	@Deprecated
	public static final void sub(StructureComplex z, StructureComplex a)
	{
		z.sub(a);
	}

	@Deprecated
	public static final void sub(StructureComplex z, double r, double i)
	{
		z.sub(r, i);
	}

	@Deprecated
	public static final void sub(StructureComplex z, double r)
	{
		z.sub(r);
	}

	//

	@Deprecated
	public static final void mul(StructureComplex z, StructureComplex a)
	{
		z.mul(a);
	}

	@Deprecated
	public static final void mul(StructureComplex z, double r, double i)
	{
		z.mul(r, i);
	}

	@Deprecated
	public static final void mul(StructureComplex z, double r)
	{
		z.mul(r);
	}

	//

	@Deprecated
	public static final void div(StructureComplex z, StructureComplex a)
	{
		z.div(a);
	}

	@Deprecated
	public static final void div(StructureComplex z, double r, double i)
	{
		z.div(r, i);
	}

	@Deprecated
	public static final void div(StructureComplex z, double r)
	{
		z.div(r);
	}

	//

	@Deprecated
	public static final void neg(StructureComplex z)
	{
		z.re = -z.re;
		z.im = -z.im;
	}

	@Deprecated
	public static final void con(StructureComplex z)
	{
		z.im = -z.im;
	}

	@Deprecated
	public static final void negcon(StructureComplex z)
	{
		z.re = -z.re;
	}

	@Deprecated
	public static final void inv(StructureComplex z)
	{
		z.inv();
	}

}
