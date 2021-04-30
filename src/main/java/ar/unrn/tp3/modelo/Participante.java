package ar.unrn.tp3.modelo;

public class Participante {
    private String nombre;
    private String telefono;
    private String region;

    public Participante( String nombre,String telefono,String region)throws RuntimeException {
        if (nombre.equals(""))
            throw new RuntimeException("Debe cargar un nombre");
        this.nombre = nombre;
        if (telefono.equals(""))
            throw new RuntimeException("Debe cargar el Telefono");

        if (!validarTelefono( telefono))
            throw new RuntimeException("El teléfono debe ingresarse de la siguiente forma: NNNN-NNNNNN");
        this.telefono = telefono;
        if (!region.equals("China") && !region.equals("US") && !region.equals("Europa"))
            throw new RuntimeException("Region desconocida. Las conocidas son: China, US, Europa");
        this.region = region;
}
        private boolean validarTelefono(String telefono) {
            String regex = "\\d{4}-\\d{6}";
            return telefono.matches(regex);
    }

    public String obtenerNombre() {
        return nombre;
    }

    public String obtenerTelefono() {
        return telefono;
    }

    public String obtenerRegion() {
        return region;
    }
}
