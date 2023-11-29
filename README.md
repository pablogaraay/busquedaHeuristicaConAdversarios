# busquedaHeuristicaSinAdversarios

### Enunciado
El propósito de esta práctica es que el alumno reutilice código que implementa el algoritmo A*. Se bajará código de Github, y lo utilizará para ejecutar este algoritmo para un grafo concreto.

#### Pasos a realizar
En primer lugar, debe bajarse de Github el código de algoritmos y estructuras de datos en Java de Justin Wetherell:

> git clone https://github.com/phishman3579/java-algorithms-implementation.git

A continuación, examine el código de la clase AStar.java, más concretamente, el método aStar. Luego, examine los tests del A* que hay en:

> java-algorithms-implementation/test/com/jwetherell/algorithms/graph/test/Graphs.java 

Después, de forma gradual, desarrolle la clase principal donde estará el programa de la práctica. Comience con un código sencillo:
```java
 package aplicacion;

 public class Main {
     public static void main(String[] args) {
         System.out.println("Esto es una prueba");
     }
 }
```
 Es muy importante que no olvide la línea 
 
> package aplicacion;

Para poderlo compilar y ejecutar sin necesidad de crear ningún proyecto en un IDE (p.ej. Netbeans), modifique el fichero build.xml de la siguiente forma.

En la zona indicada por

> <!– set global properties for this build –>

se debe añadir la siguiente línea de código:

```xml
<property name="main-class" value="aplicacion.Main"/>
```
El target de dist también se debe modificar para que quede de la siguiente manera:

```xml
<target name="dist" depends="build" description="generate the distribution">
   <jar jarfile="${dist}/java-algorithms-implementation-${DSTAMP}.jar"basedir="${build}">
       <manifest>
           <attribute name="Main-Class" value="${main-class}"/>
       </manifest>
   </jar>
</target>
```

Luego, se añade:

```xml
<target name="run_main" depends="dist">
   <java jar="${dist}/java-algorithms-implementation-${DSTAMP}.jar"fork="true"/>
</target>
```


A continuación se comprueba que el programa funciona:

> ant run_main

Después, tomando como referencia los tests, se crea un programa principal que genere un camino aplicando A*.

A continuación, responda a las siguientes preguntas:

- ¿Qué variable representa la lista ABIERTA?
* ¿Qué variable representa la función g?
+ ¿Qué variable representa la función f ?
- ¿Qué método habría que modificar para que la heurística representarala distancia aérea entre vértices?
* ¿Realiza este método reevaluación de nudos cuando se encuentra una nueva ruta a un determinado vértice? Justifique la respuesta.

#### Material a entregar

Deberá ser el siguiente:

1. El proyecto completo, es decir, lo que se ha bajado inicialmente de Github más el código implementado.
2. README.md en formato Markdown respondiendo a las preguntas que seplantean en el presente enunciado.

### Resolución de la práctica:

Para la resolución de la práctica, se ha desarrollado una clase principal que contiene un método **main**:

```java

public static void main(String[] args){
  AStar<Integer> aStar = new AStar<Integer>();
  UndirectedGraph grafoIndirecto = new UndirectedGraph();
  List<Graph.Edge<Integer>> ruta = aStar.aStar(grafoIndirecto.graph, grafoIndirecto.v1, grafoIndirecto.v7);
  System.out.println(ruta);
}
```

Dentro de la clase principal, para este ejemplo, se implementa la clase *UndirectedGraph* (grafo sin dirección).

```java
private static class UndirectedGraph{

    final List<Vertex<Integer>> verticies = new ArrayList<Vertex<Integer>>();
          final Graph.Vertex<Integer> v1 = new Graph.Vertex<Integer>(1);
        	final Graph.Vertex<Integer> v2 = new Graph.Vertex<Integer>(2);
        	final Graph.Vertex<Integer> v3 = new Graph.Vertex<Integer>(3);
        	final Graph.Vertex<Integer> v4 = new Graph.Vertex<Integer>(4);
        	final Graph.Vertex<Integer> v5 = new Graph.Vertex<Integer>(5);
        	final Graph.Vertex<Integer> v6 = new Graph.Vertex<Integer>(6);
        	final Graph.Vertex<Integer> v7 = new Graph.Vertex<Integer>(7);
        	final Graph.Vertex<Integer> v8 = new Graph.Vertex<Integer>(8);

        	{
            	verticies.add(v1);
            	verticies.add(v2);
            	verticies.add(v3);
            	verticies.add(v4);
            	verticies.add(v5);
            	verticies.add(v6);
            	verticies.add(v7);
            	verticies.add(v8);
        	}

        	final List<Edge<Integer>> edges = new ArrayList<Edge<Integer>>();
        	final Graph.Edge<Integer> e1_2 = new Graph.Edge<Integer>(7, v1, v2);
        	final Graph.Edge<Integer> e1_3 = new Graph.Edge<Integer>(9, v1, v3);
        	final Graph.Edge<Integer> e1_6 = new Graph.Edge<Integer>(14, v1, v6);
        	final Graph.Edge<Integer> e2_3 = new Graph.Edge<Integer>(10, v2, v3);
        	final Graph.Edge<Integer> e2_4 = new Graph.Edge<Integer>(15, v2, v4);
        	final Graph.Edge<Integer> e3_4 = new Graph.Edge<Integer>(11, v3, v4);
        	final Graph.Edge<Integer> e3_6 = new Graph.Edge<Integer>(2, v3, v6);
        	final Graph.Edge<Integer> e6_5 = new Graph.Edge<Integer>(9, v6, v5);
        	final Graph.Edge<Integer> e6_8 = new Graph.Edge<Integer>(14, v6, v8);
        	final Graph.Edge<Integer> e4_5 = new Graph.Edge<Integer>(6, v4, v5);
        	final Graph.Edge<Integer> e4_7 = new Graph.Edge<Integer>(16, v4, v7);
        	final Graph.Edge<Integer> e1_8 = new Graph.Edge<Integer>(30, v1, v8);

        	{
            	edges.add(e1_2);
            	edges.add(e1_3);
            	edges.add(e1_6);
            	edges.add(e2_3);
            	edges.add(e2_4);
            	edges.add(e3_4);
            	edges.add(e3_6);
            	edges.add(e6_5);
            	edges.add(e6_8);
            	edges.add(e4_5);
            	edges.add(e4_7);
            	edges.add(e1_8);
        	}

        	final Graph<Integer> graph = new Graph<Integer>(Graph.TYPE.DIRECTED, verticies, edges);		
}
```
#### Ejecución del código 

Tras ejecutar el comando ```ant run_main``` el output será el siguiente:

```
     [java] [[ 1(0) ] -> [ 3(0) ] = 9
     [java] , [ 3(0) ] -> [ 4(0) ] = 11
     [java] , [ 4(0) ] -> [ 7(0) ] = 16
     [java] ]
```

#### Respuestas a preguntas propuestas

1. ¿Qué variable representa la lista ABIERTA?

> La variable **openSet** representa la lista ABIERTA.
> Esta variable se encuentra dentro del método **aStar** en la clase **AStar**.

```java
final List<Graph.Vertex<T>> openSet = new ArrayList<Graph.Vertex<T>>(size);
```
   
2. ¿Qué variable representa la función g?

> La variable **gScore** representa la función g.
> Esta variable se encuentra dentro del método **aStar** en la clase **AStar**.

```java
final Map<Graph.Vertex<T>,Integer> gScore = new HashMap<Graph.Vertex<T>,Integer>();
```

3. ¿Qué variable representa la función f?

> La variable **fScore** representa la función f.
> Esta variable se encuentra dentro del método **aStar** en la clase **AStar**.

```java
final Map<Graph.Vertex<T>,Integer> fScore = new HashMap<Graph.Vertex<T>,Integer>();
```

4. ¿Qué método habría que modificar para que la heurística representara la distancia aérea entre vértices?

> Habría que modificar el método **heuristicCostEstimate** de la clase **AStar**.

```java
/**
* Default heuristic: cost to each vertex is 1.
*/
@SuppressWarnings("unused") 
protected int heuristicCostEstimate(Graph.Vertex<T> start, Graph.Vertex<T> goal) {
     return 1;
}
```

5. ¿Realiza este método reevaluación de nudos cuando se encuentra una nueva ruta a un determinado vértice? Justifique la respuesta.

> El método utilizado para la reevaluación de nudos es el método **reconstructPath** de la clase **AStar**.

```java
private List<Graph.Edge<T>> reconstructPath(Map<Graph.Vertex<T>,Graph.Vertex<T>> cameFrom, Graph.Vertex<T> current) {
    final List<Graph.Edge<T>> totalPath = new ArrayList<Graph.Edge<T>>();

    while (current != null) {
        final Graph.Vertex<T> previous = current;
        current = cameFrom.get(current);
        if (current != null) {
            final Graph.Edge<T> edge = current.getEdge(previous);
            totalPath.add(edge);
        }
    }
    Collections.reverse(totalPath);
    return totalPath;
}
```
