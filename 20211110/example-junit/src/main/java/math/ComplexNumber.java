package math;

import java.util.Objects;

/**
 * Represents a complex number which is a number that can be expressed in the form  a + bi, where a
 * and b are real numbers, and "i" is a symbol, called the imaginary unit, that satisfies the
 * equation i^2 = −1.
 */
public class ComplexNumber {

  /**
   * The real part of this complex number.
   */
  private final double real;

  /**
   * The imaginary part of thi complex number.
   */
  private final double imaginary;

  /**
   * Constructs a complex number with the specified real and imaginary part.
   *
   * @param real      the real part of the complex number
   * @param imaginary the imaginary part of the complex number
   */
  public ComplexNumber(final double real, final double imaginary) {
    this.real = real;
    this.imaginary = imaginary;
  }

  /**
   * Constructs a complex number with the specified real and imaginary part.
   *
   * @param real      the real part of the complex number
   * @param imaginary the imaginary part of the complex number
   * @return the constructed complex number
   */
  public static ComplexNumber of(final double real, final double imaginary) {
    return new ComplexNumber(real, imaginary);
  }

  /**
   * Returns the real part of this complex number.
   *
   * @return the real part of this complex number
   */
  public double getReal() {
    return real;
  }

  /**
   * Returns the imaginary part of this complex number.
   *
   * @return the imaginary part of this complex number
   */
  public double getImaginary() {
    return imaginary;
  }

  /**
   * Computes the sum of this complex number with the other complex number.
   *
   * @param other the summand to be added
   * @return the sum of this complex number with the other complex number
   */
  public ComplexNumber plus(ComplexNumber other) {
    return new ComplexNumber(real + other.real, imaginary + other.imaginary);
  }

  /**
   * Computes the difference of this complex number with the other complex number.
   *
   * @param other the subtrahend to be subtracted
   * @return the difference of this complex number with the other complex number
   */
  public ComplexNumber minus(ComplexNumber other) {
    return new ComplexNumber(real - other.real, imaginary - other.imaginary);
  }

  /**
   * Computes the product of this complex number with the other complex number.
   *
   * @param other the factor to be multiplied
   * @return the product of this complex number with the other complex number
   */
  public ComplexNumber times(ComplexNumber other) {
    final var real = this.real * other.real - this.imaginary * other.imaginary;
    final var imaginary = this.real * other.imaginary + this.imaginary * other.real;
    return new ComplexNumber(real, imaginary);
  }

  /**
   * Computes the quotient  of this complex number with the other complex number.
   *
   * @param other the divisor  to be divided
   * @return the quotient  of this complex number with the other complex number
   */
  public ComplexNumber divides(ComplexNumber other) {
    return this.times(other.reciprocal());
  }

  /**
   * Computes the magnitude (also called absolute value or modulus), its distance from the origin in
   * the complex plane, of this complex number.
   *
   * @return the magnitude of this complex number
   */
  public double magnitude() {
    return Math.hypot(real, imaginary);
  }

  /**
   * Computes the angle (also called argument or phase), between the positive real axis and the line
   * joining the origin and z, represented as a point in the complex plane, of this complex number.
   *
   * @return the angle of this complex number
   */
  public double angle() {
    return Math.atan2(imaginary, real);
  }

  /**
   * Computes the scaling of this complex number with the specified scaling factor.
   *
   * @param factor the scaling factor
   * @return the scaling of this complex number with the specified scaling factor
   */
  public ComplexNumber scale(double factor) {
    return new ComplexNumber(factor * real, factor * imaginary);
  }

  /**
   * Computes the conjugated form of this complex number where the real part is equal but the
   * imaginary part has the opposite sign.
   *
   * @return the conjugated form of this complex number
   */
  public ComplexNumber conjugate() {
    return new ComplexNumber(real, -imaginary);
  }

  /**
   * Computes the reciprocal of this complex number.
   *
   * @return the reciprocal of this complex number
   */
  public ComplexNumber reciprocal() {
    final var scale = real * real + imaginary * imaginary;
    return new ComplexNumber(real / scale, -imaginary / scale);
  }

  /**
   * Computes the exponential form of this complex number.
   *
   * @return the exponential form of this complex number
   */
  public ComplexNumber exp() {
    final var real = Math.exp(this.real) * Math.cos(this.imaginary);
    final var imaginary = Math.exp(this.real) * Math.sin(this.imaginary);
    return new ComplexNumber(real, imaginary);
  }

  /**
   * Computes the sine of this complex number.
   *
   * @return the sine of this complex number
   */
  public ComplexNumber sin() {
    final var real = Math.sin(this.real) * Math.cosh(this.imaginary);
    final var imaginary = Math.cos(this.real) * Math.sinh(this.imaginary);
    return new ComplexNumber(real, imaginary);
  }


  /**
   * Computes the cosine of this complex number.
   *
   * @return the cosine of this complex number
   */
  public ComplexNumber cos() {
    final var real = Math.cos(this.real) * Math.cosh(this.imaginary);
    final var imaginary = -Math.sin(this.real) * Math.sinh(this.imaginary);
    return new ComplexNumber(real, imaginary);
  }

  /**
   * Computes the tangent of this complex number.
   *
   * @return the tangent of this complex number
   */
  public ComplexNumber tan() {
    return this.sin().divides(this.cos());
  }

  @Override
  public String toString() {
    if (imaginary < 0) {
      return String.format("%f - %fi", real, -imaginary);
    }
    return String.format("%f + %fi", real, imaginary);
  }

  @Override
  public boolean equals(final Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof ComplexNumber)) {
      return false;
    }
    final ComplexNumber that = (ComplexNumber) o;
    return Double.compare(that.real, real) == 0
        && Double.compare(that.imaginary, imaginary) == 0;
  }

  @Override
  public int hashCode() {
    return Objects.hash(real, imaginary);
  }
}
