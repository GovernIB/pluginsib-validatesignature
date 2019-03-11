# ![Logo](https://github.com/GovernIB/maven/raw/binaris/pluginsib/projectinfo_Attachments/icon.jpg) pluginsib-validatesignature-2.0 
*API i Plugins de Validació de Firmes*

***Descripció***

Repositori que permet la validació de Firmes emprant Integr@ (integra), servidor @Firma (afirmacxf), eSignature (eSignature) i implementació buida (fake).

També inclou un testejador del plugins de validació de firmes via web (validatetester).

#### ***Documentació***

Directori | Descripció | Documentació
------------ | ------------- | -------------
------------ | ------------- | -------------

***Implementacions***

Directori | Descripció | Documentació
------------ | ------------- | -------------
api | API de validatesignature | --
afirmacxf | Servei de validació que ataca als servidors de @Firma mitjançant WS. | [Fitxers de configuració](./afirmacxf/config)
eSignature | Serveis de validació de firma que ataquen al WS de eSignature. | [Fitxers de configuració](./esignature/config)
fake | Implementació buida. | --
integra | Servei de validació de firma amb les llibreries de Integra. | [Fitxers de configuració](./integra/conf)
validatetester | Tester del plugins de validació de firmes via web. | --
