package org.generation.italy.bibliotecaQuartiere.servlet;

import org.generation.italy.bibliotecaQuartiere.servlet.control.CittadinoServletJ2EE;
import org.generation.italy.bibliotecaQuartiere.servlet.model.BibliotecaModelException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServletConfig {

    @Autowired
    private CittadinoServletJ2EE cittadinoServlet;

    @Bean
    ServletRegistrationBean<CittadinoServletJ2EE> CittadinoServletRegistration() {
        ServletRegistrationBean<CittadinoServletJ2EE> registrationBean =
                new ServletRegistrationBean<>(cittadinoServlet, "/servlet/cittadino/*");

        return registrationBean;
    }
    
//    @Bean	
//    public ServletRegistrationBean<CittadinoServletJ2EE> countryServlet() throws BibliotecaModelException {
// 	   ServletRegistrationBean<CittadinoServletJ2EE> servRegBean = new ServletRegistrationBean<>();
// 	   servRegBean.setServlet(new CittadinoServletJ2EE());
// 	   servRegBean.addUrlMappings("/servlet/cittadino/elenco-libri");
// 	   servRegBean.addUrlMappings("/servlet/cittadino/assegna-libro");
// 	   servRegBean.addUrlMappings("/servlet/cittadino/libri-prenotati");
// 	   servRegBean.setLoadOnStartup(1);
// 	   return servRegBean;
//    }
   
}
