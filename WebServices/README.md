# WEB SERVICES

A Web service, in very broad terms, is a method of communication between two applications or electronic devices over the World Wide Web (WWW). Web services are of two kinds: Simple Object Access Protocol (SOAP) and Representational State Transfer (REST).

# REST vs SOAP

SOAP (**Simple Object Access Protocol**) and REST (**Representational State Transfer**) are both web service communication protocols. SOAP was long the standard approach to web service interfaces, although it’s been dominated by REST in recent years, with REST now representing more than 70% of public APIs. 

**SOAP** defines a standard communication protocol (set of rules) specification for XML-based message exchange. SOAP uses different transport protocols, such as HTTP and SMTP. The standard protocol HTTP makes it easier for SOAP model to tunnel across firewalls and proxies without any modifications to the SOAP protocol. SOAP can sometimes be slower than middleware technologies like CORBA or ICE due to its verbose XML format.

**REST** describes a set of architectural principles by which data can be transmitted over a standardized interface (such as HTTP). REST does not contain an additional messaging layer and focuses on design rules for creating stateless services. A client can access the resource using the unique URI and a representation of the resource is returned. With each new resource representation, the client is said to transfer state. While accessing RESTful resources with HTTP protocol, the URL of the resource serves as the resource identifier and GET, PUT, DELETE, POST and HEAD are the standard HTTP operations to be performed on that resource.
