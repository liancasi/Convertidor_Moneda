import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Moneda {
    private double valorMoneda;
    private String tipoMoneda;
    private double valorMonedaConvertido;
    private String tipoMonedaConvertido;
    private LocalDateTime fechaConversion;

    public Moneda(double valorMoneda, String tipoMoneda, double valorMonedaConvertido, String tipoMonedaConvertido) {
        this.valorMoneda = valorMoneda;
        this.tipoMoneda = tipoMoneda;
        this.valorMonedaConvertido = valorMonedaConvertido;
        this.tipoMonedaConvertido = tipoMonedaConvertido;
        this.fechaConversion = LocalDateTime.now();
    }

    public double getValorMoneda() {
        return valorMoneda;
    }

    public void setValorMoneda(double valorMoneda) {
        this.valorMoneda = valorMoneda;
    }

    public String getTipoMoneda() {
        return tipoMoneda;
    }

    public void setTipoMoneda(String tipoMoneda) {
        this.tipoMoneda = tipoMoneda;
    }

    public double getValorMonedaConvertido() {
        return valorMonedaConvertido;
    }

    public void setValorMonedaConvertido(double valorMonedaConvertido) {
        this.valorMonedaConvertido = valorMonedaConvertido;
    }

    public String getTipoMonedaConvertido() {
        return tipoMonedaConvertido;
    }

    public void setTipoMonedaConvertido(String tipoMonedaConvertido) {
        this.tipoMonedaConvertido = tipoMonedaConvertido;
    }

    public LocalDateTime getFechaConversion() {
        return fechaConversion;
    }

    public void setFechaConversion(LocalDateTime fechaConversion) {
        this.fechaConversion = fechaConversion;
    }

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return  fechaConversion.format(formatter)+" El valor " + valorMoneda +" ["+ tipoMoneda + "] "+
                "corresponde al valor finalde =>>> "
                + valorMonedaConvertido+" ["+ tipoMonedaConvertido + "] ";
    }
}
