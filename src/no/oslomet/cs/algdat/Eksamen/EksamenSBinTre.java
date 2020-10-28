package no.oslomet.cs.algdat.Eksamen;


import java.util.*;

public class EksamenSBinTre<T> {
    private static final class Node<T>   // en indre nodeklasse
    {
        private T verdi;                   // nodens verdi
        private Node<T> venstre, høyre;    // venstre og høyre barn
        private Node<T> forelder;          // forelder

        // konstruktør
        private Node(T verdi, Node<T> v, Node<T> h, Node<T> forelder) {
            this.verdi = verdi;
            venstre = v;
            høyre = h;
            this.forelder = forelder;
        }

        private Node(T verdi, Node<T> forelder)  // konstruktør
        {
            this(verdi, null, null, forelder);
        }

        @Override
        public String toString() {
            return "" + verdi;
        }

    } // class Node

    private Node<T> rot;                            // peker til rotnoden
    private int antall;                             // antall noder
    private int endringer;                          // antall endringer

    private final Comparator<? super T> comp;       // komparator

    public EksamenSBinTre(Comparator<? super T> c)    // konstruktør
    {
        rot = null;
        antall = 0;
        comp = c;
    }

    public boolean inneholder(T verdi) {
        if (verdi == null) return false;

        Node<T> p = rot;

        while (p != null) {
            int cmp = comp.compare(verdi, p.verdi);
            if (cmp < 0) p = p.venstre;
            else if (cmp > 0) p = p.høyre;
            else return true;
        }

        return false;
    }

    public int antall() {
        return antall;
    }

    public String toStringPostOrder() {
        if (tom()) return "[]";

        StringJoiner s = new StringJoiner(", ", "[", "]");

        Node<T> p = førstePostorden(rot); // går til den første i postorden
        while (p != null) {
            s.add(p.verdi.toString());
            p = nestePostorden(p);
        }

        return s.toString();
    }

    public boolean tom() {
        return antall == 0;
    }

    public final boolean leggInn(T verdi)    // skal ligge i class SBinTre
    {
        Objects.requireNonNull(verdi, "Ulovlig med nullverdier!");

        Node<T> p = rot, q = null;               // p starter i roten
        int cmp = 0;                             // hjelpevariabel

        while (p != null)       // fortsetter til p er ute av treet
        {
            q = p;                                 // q er forelder til p
            cmp = comp.compare(verdi,p.verdi);     // bruker komparatoren
            p = cmp < 0 ? p.venstre : p.høyre;     // flytter p
        }

        // p er nå null, dvs. ute av treet, q er den siste vi passerte

        p = new Node<T>(verdi, q);                   // oppretter en ny node

        if (q == null) rot = p;                  // p blir rotnode
        else if (cmp < 0) q.venstre = p;         // venstre barn til q
        else q.høyre = p;                        // høyre barn til q

        antall++;                                // én verdi mer i treet
        return true;                             // vellykket innlegging
    }

    public boolean fjern(T verdi){
        if (null == verdi){
            return false;
        }

        Node <T> p = rot, q = null;

        while (p != null){
            int compare = comp.compare(verdi, p.verdi);
            if (compare < 0){
                q = p;
                p = p.venstre;
            }
            else if (compare > 0){
                q = p;
                p = p.høyre;
            }
            break;

        }
        if (p == null){
            return false;
        }
        if (p.venstre == null || p.høyre == null){
            Node<T> barn = p.venstre != null ? p.venstre : p.høyre;

            if (barn != null){
                barn.forelder = q;
            }
            if (p == rot){
                rot = barn;
            }
            else if (p == q.venstre){
                q.venstre = barn;
            }
            else if (p == q.venstre){
                q.venstre = barn;

            }
            else q.høyre = barn;
        }

        else {
            Node <T> s = p, r = p.høyre;
            while (r.venstre != null){
                s = r;
                r = r.venstre;
            }
            p.verdi = r.verdi;

            if (r.høyre != null) {
                s = r.høyre.forelder;
            }
            if (s != p){
                s.venstre = r.høyre;
            }
            else {
                s.høyre = r.høyre;
            }
        }
        antall--;
        endringer++;
        return true;
    }

    public int fjernAlle(T verdi) {
        int count = 0;
        while (fjern(verdi)){
            count++;
        }
        return count;
    }

    public int antall(T verdi) {
        if (verdi == null) return 0;

        int count = 0;

        Node<T> p = rot;

        while (p != null){
            int cmp = comp.compare(verdi, p.verdi);
            if (cmp < 0) p = p.venstre;
            else {
                if (cmp == 0) count++;
                p = p.høyre;
            }
        }
        return count;
    }

    private static <T> void nullstill(Node<T> p){
        if (p.høyre != null){
            nullstill (p.høyre);
            p.høyre = null;
        }

        if (p.venstre != null){
            nullstill(p.venstre);
            p.venstre = null;
        }

        p.verdi = null;
    }

    public void nullstill() {
        throw new UnsupportedOperationException("Ikke kodet ennå!");
    }

    private static <T> Node<T> førstePostorden(Node<T> p) {
        if (p == null) throw new NoSuchElementException("Tom node!");

        while (true) {
            if (p.venstre != null) p = p.venstre;
            else if (p.høyre != null) p = p.høyre;
            else return p;
        }
    }


    private static <T> Node<T> nestePostorden(Node<T> p) {
        Node<T> n = p.forelder;

        while (n != null) {
            if (n.venstre == p) {
                p = p.forelder;

                if (n.høyre == null) {
                    return p;
                }

                else {
                    p = p.høyre;
                    if (p.venstre ==null && p.høyre == null)
                        return p;
                    else
                        return førstePostorden(p);
                }
            }

            else if (n.høyre == p) {
                p = p.forelder;
                return p;
            }
        }

        return null;

    }

    public void postorden(Oppgave<? super T> oppgave) {
        Node<T> p = førstePostorden(rot);

        while (p != null) {
            oppgave.utførOppgave(p.verdi);
            p = nestePostorden(p);
        }
    }

    public void postordenRecursive(Oppgave<? super T> oppgave) {
        if (!tom()) postordenRecursive(rot, oppgave);
    }

    private void postordenRecursive(Node<T> p, Oppgave<? super T> oppgave) {
        if (p == null) return;

        postordenRecursive(p.venstre, oppgave);

        postordenRecursive(p.høyre, oppgave);

        oppgave.utførOppgave(p.verdi);
    }

    public ArrayList<T> serialize() {
        if (tom()) return new ArrayList<>();

        ArrayList<Node<T>> kø = new ArrayList<>();
        ArrayList<T> serialisering = new ArrayList<>();
        kø.add(rot);
        while (!kø.isEmpty()) {
            Node<T> current = kø.remove(0);
            if (current != null) {
                serialisering.add(current.verdi);
                kø.add(current.venstre);
                kø.add(current.høyre);
            }
        }
        return serialisering;
    }

    static <K> EksamenSBinTre<K> deserialize(ArrayList<K> data, Comparator<? super K> c) {
        if (data.size() == 0 || data == null) {

            return null;
        }
        EksamenSBinTre<K> node = new EksamenSBinTre<>(c);
        for (K t : data) node.leggInn(t);

        return node;
    }


} // ObligSBinTre
