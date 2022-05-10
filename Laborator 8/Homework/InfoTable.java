public enum InfoTable {
    CONTINENTS {
        @Override
        public String toString(){
            return "continents";
        }
    },
    COUNTRIES{
        @Override
        public String toString(){
            return "countries";
        }
    },
    CITIES{
        @Override
        public String toString(){
            return "cities";
        }
    },
}
