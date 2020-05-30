class sugeridorDePrendas{
    List<Prenda> prendas = new ArrayList();
    ServicioMeteorologico apiClima = new ServicioMeteorologico(“Buenos Aires, Argentina”);
    List<Atuendo> atuendosSugeridos = new ArrayList();
    Validador validadorDeAtuendos;

    List<Prenda> generarAtuendo(){
          
        double temperatura = apiClima.condicionesClimaticas();
        
        prenda.aguantaClima(temperatura) && !this.seMojaSiUsaPrenda(unaPrenda);
        
    }

    bool seMojaSiUsa(Prenda unaPrenda){

    	if(apiClima.altaProbabilidadDeLluvia()){
    		return !prenda.seBancaLluvia()
    	}else{
           return  false;   
    	}
    }

    void sugerirAtuendo(Atuendo unAtuendo){
        validadorDeAtuendos.validarAtuendo(unAtuendo);
    }
}


class Atuendo{
    List<Prenda> prendas;

    List<Categoria> categoriasOcupadas(){
        return prendas.map(prenda->prenda.categoria());
    }

    bool categoriaCompleta(){
       List<Categoria> categoriasOcupadas = this.categoriasOcupadas(); 

        for(Categoria.categoria: Categoria.values){
            if(unAtuendo.categoriasOcupadas.contains(Categoria.categoria)==false) return false;         
        }
        return true;
    }
}

class Prenda(){
    double climaMinimo;
    double climaMaximo;

    bool seBancaLluvia;

    bool aguantaClima(double temperatura){
        return this.aguantaCalor(temperatura);
    }

    bool aguantaCalor(double temperatura){
        return temperatura < climaMaximo; 
    }

    bool aguantaFrio(double temperatura){
        return temperatura > climaMinimo;
    }

}

enum Categoria{
    remera,pantalon, zapatos,gorro...;
}

class Validador{
    List<Validacion>validaciones = new ArrayList();

    void validarAtuendo(Atuendo unAtuendo){
        validaciones.forEach(validacion->validacion.validarAtuendo(unAtuendo));
    }

    void agregarValidacion(Validacion unaValidacion){
        validaciones.add(unaValidacion);
    }

    bool unaCategoriaPorPrenda(Atuendo unAtuendo){
         List<Categoria> categoriasOcupadas = unAtuendo.categoriasOcupadas();
         return categoriasOcupadas.forEach(categoria -> categoriasOcupadas.count(categoria) == 1);
    }
}

class ServicioMeteorologico{
    private AccuWeatherAPI apiClima = new AccuWeatherAPI();
    double probabilidadEstablecida;

    double clima(String ciudad){
        double clima = this.condicionesClimaticas().value();
        return clima;
    }

    List<Map<String, Object>> condicionesClimaticas(String ciudad){
        return apiClima.getWeather(ciudad);
    }  
    
    double probabilidadLluvia(){
        return this.condicionesClimaticas.get(0).get("PrecipitationProbability"); 
    }

    bool altaProbabilidadDeLluvia(){
        return this.probabilidadesDeLluvia() >= probabilidadEstablecida;
    }
}
