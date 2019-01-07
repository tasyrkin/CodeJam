import networkx as nx

# Create Directed Graph
G=nx.DiGraph()

# Add a list of nodes:
G.add_nodes_from(["1","2","3","4","5","6","7","9"])

# Add a list of edges:
G.add_edges_from([("7","9"),("1","2"),("2","3"),("3","1"),("3","4"),("4","5"),("5","1"),("5","6"),("6","7"),("7","2")])

#Return a list of cycles described as a list o nodes
all_cycles = list(nx.simple_cycles(G))

#Find longest cycle
answer = []
longest_cycle_len = 0
for cycle in all_cycles:
    cycle_len = len(cycle)
    if cycle_len>longest_cycle_len:
        answer =cycle
        longest_cycle_len = cycle_len

print "Longest Cycle is {} with length {}.".format(answer,longest_cycle_len)
