
 - Crear fitxer "test.properties" amb el hostname del JBoss
 - Crear fitxer "plugin.properties" amb les propietats des plugins.
 - Fixar la propietat de sistema "org.fundaciobit.plugins.validatesignature.path" dins el JBoss que apunti al directori
on s'ubica el fitxer plugin.properties
 - Executar mvn verify per compilar
 - Desplegar signaturewebtester.war dins el JBoss
 - Executar tests amb mvn -PtestsIntegracio verify