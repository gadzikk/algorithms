package zobjects;

/**
 * Created by gadzik on 15.08.20.
 */
public class GraphE {
    public int V, E;
    public EdgeW edge[];

    public GraphE(int v, int e) {
        V = v;
        E = e;
        edge = new EdgeW[e];
        for (int i = 0; i < e; ++i) {
            edge[i] = new EdgeW();
        }
    }
}
