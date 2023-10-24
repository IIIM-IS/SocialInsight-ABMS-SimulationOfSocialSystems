import matplotlib.pyplot as plt
import networkx as nx
import pygraphviz as pgv

def generate_interfacing_program_to_ontology():
    """Generate a detailed diagram of the Interfacing Program to the Ontology."""
    G = pgv.AGraph(strict=False, directed=True)

    # Nodes
    nodes = ['GUI', 'Node Graph', 'Editing Pane', 'Annotations', 'NLP Engine', 'OpenNLP', 'Ontology', 'Upper-level Ontology', 'Domain-specific Ontology']
    for node in nodes:
        G.add_node(node, shape='box')

    # Edges
    edges = [
        ('GUI', 'Node Graph'),
        ('Node Graph', 'Editing Pane'),
        ('Editing Pane', 'Annotations'),
        ('GUI', 'NLP Engine'),
        ('NLP Engine', 'OpenNLP'),
        ('NLP Engine', 'Ontology'),
        ('Ontology', 'Upper-level Ontology'),
        ('Ontology', 'Domain-specific Ontology')
    ]
    for edge in edges:
        G.add_edge(*edge)

    G.layout(prog='dot')
    G.draw('interfacing_program_to_ontology.png')
    plt.imshow(plt.imread('interfacing_program_to_ontology.png'))
    plt.axis('off')
    plt.title('Interfacing Program to the Ontology')
    plt.savefig('generate_interfacing_program_to_ontology.png')
    plt.close()

def generate_experiment_creation_interface():
    """Generate a detailed diagram of the Interface Mechanism for Experiment Creation."""
    G = pgv.AGraph(strict=False, directed=True)

    # Nodes
    nodes = ['Experiment Creation Interface', 'Data Input', 'CSV Upload', 'API Connection', 'Base Environment Definition', 'CPU Usage', 'Memory Allocation', 'Risk-Protected Factors', 'Protective Factor', 'Risk Factor']
    for node in nodes:
        G.add_node(node, shape='box')

    # Edges
    edges = [
        ('Experiment Creation Interface', 'Data Input'),
        ('Data Input', 'CSV Upload'),
        ('Data Input', 'API Connection'),
        ('Experiment Creation Interface', 'Base Environment Definition'),
        ('Base Environment Definition', 'CPU Usage'),
        ('Base Environment Definition', 'Memory Allocation'),
        ('Experiment Creation Interface', 'Risk-Protected Factors'),
        ('Risk-Protected Factors', 'Protective Factor'),
        ('Risk-Protected Factors', 'Risk Factor')
    ]
    for edge in edges:
        G.add_edge(*edge)

    G.layout(prog='dot')
    G.draw('experiment_creation_interface.png')
    plt.imshow(plt.imread('experiment_creation_interface.png'))
    plt.axis('off')
    plt.title('Interface Mechanism for Experiment Creation')
    plt.savefig('generate_experiment_creation_interface.png')
    plt.close()

def generate_output_interface():
    """Generate a detailed diagram of the Output Interface."""
    G = pgv.AGraph(strict=False, directed=True)

    # Nodes
    nodes = ['Output Interface', 'Dashboard', 'Real-time Graphs', 'Heat Maps', 'Interactive Controls', 'Data Output', 'CSV', 'JSON']
    for node in nodes:
        G.add_node(node, shape='box')

    # Edges
    edges = [
        ('Output Interface', 'Dashboard'),
        ('Dashboard', 'Real-time Graphs'),
        ('Dashboard', 'Heat Maps'),
        ('Dashboard', 'Interactive Controls'),
        ('Output Interface', 'Data Output'),
        ('Data Output', 'CSV'),
        ('Data Output', 'JSON')
    ]
    for edge in edges:
        G.add_edge(*edge)

    G.layout(prog='dot')
    G.draw('output_interface.png')
    plt.imshow(plt.imread('output_interface.png'))
    plt.axis('off')
    plt.title('Output Interface')
    plt.savefig('generate_output_interface.png')
    plt.close()


def generate_UML_diagram():
    """Generate a Unified Modeling Language (UML) diagram to visualize the system architecture."""
    G = pgv.AGraph(strict=False, directed=True)

    # Nodes representing core components
    nodes = ['Upper-level Ontology', 'Domain-specific Ontology', 'ABM Framework', 'Ontology Editor/Interfacer', 
             'Experiment Creation Interface', 'Output Interface']
    for node in nodes:
        G.add_node(node, shape='box')

    # Edges representing data flow and dependencies
    edges = [
        ('Upper-level Ontology', 'Ontology Editor/Interfacer'),
        ('Domain-specific Ontology', 'Ontology Editor/Interfacer'),
        ('Ontology Editor/Interfacer', 'ABM Framework'),
        ('ABM Framework', 'Experiment Creation Interface'),
        ('Experiment Creation Interface', 'Output Interface')
    ]
    for edge in edges:
        G.add_edge(*edge)

    G.layout(prog='dot')
    G.draw('uml_diagram.png')
    plt.imshow(plt.imread('uml_diagram.png'))
    plt.axis('off')
    plt.title('UML System Architecture Diagram')
    plt.savefig('generate_UML_diagram.png')
    plt.close()

def generate_sequence_diagram():
    """
    Generate a sequence diagram to illustrate the interactions between RDF, SPARQL, ABM, and Mesa.

    The generated diagram will show how these actors communicate with each other over time.
    The sequence starts with RDF encoding an ontology, which is then queried by SPARQL,
    and finally simulations are run on ABM and Mesa.
    """
    fig, ax = plt.subplots()
    
    # Define the actors involved in the sequence
    actors = ['RDF', 'SPARQL', 'ABM', 'Mesa']
    y_pos = [0, 1, 2, 3]
    
    # Draw horizontal dotted lines for each actor
    for y in y_pos:
        plt.plot([0, 8], [y, y], 'k--')

    # Draw arrows and label interactions
    plt.arrow(1, 0, 0, 1, head_width=0.1, head_length=0.1, fc='k', ec='k')
    plt.text(1.1, 0.5, "Encode Ontology", rotation=90)
    plt.arrow(3, 1, 0, 1, head_width=0.1, head_length=0.1, fc='k', ec='k')
    plt.text(3.1, 1.5, "Query", rotation=90)
    plt.arrow(5, 2, 0, 1, head_width=0.1, head_length=0.1, fc='k', ec='k')
    plt.text(5.1, 2.5, "Run Sim", rotation=90)

    # Configure axis and labels
    ax.set_yticks(y_pos)
    ax.set_yticklabels(actors)
    plt.title('Sequence Diagram')
    plt.savefig('generate_sequence_diagram.png')
    plt.close()

if __name__ == '__main__':
    generate_UML_diagram()
    generate_sequence_diagram()
    generate_interfacing_program_to_ontology()
    generate_experiment_creation_interface()
    generate_output_interface()