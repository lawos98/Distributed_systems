FROM python:3.10.10

RUN pip install --no-cache-dir -U 'ray[default]'

CMD ["bash", "-c", "ray start --head --num-cpus 1 --dashboard-host 0.0.0.0 --include-dashboard true --block"]